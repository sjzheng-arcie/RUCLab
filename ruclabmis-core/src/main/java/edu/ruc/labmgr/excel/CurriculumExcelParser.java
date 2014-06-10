package edu.ruc.labmgr.excel;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.TermYearService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.SysUtil;

import java.util.Date;
import java.util.Map;


public class CurriculumExcelParser extends POIEntityParser<Curriculum> {

    @Override
    public Curriculum mapToEntity(Map<String, Object> map) {
        Curriculum result = new Curriculum();

        Object sn_temp = map.get("class_sn");
        if(sn_temp == null)
            return null;
        if(StringUtils.isNullOrEmpty(sn_temp.toString()))
            return null;

        try
        {
            result.setSn(cellDoubleToString( map.get("curriculum_sn")));
            result.setName((String) map.get("curriculum_name"));
            result.setScore(cellDoubleToShort(map.get("score")));
            result.setCategory(cellDoubleToShort(map.get("category"))+"");
            result.setType((String) map.get("type"));

            String teacherName = (String) map.get("teacher");
            if(!StringUtils.isNullOrEmpty(teacherName))
            {
                UserService serviceUser = SysUtil.getBean("userService", UserService.class);
                Integer teacherId = serviceUser.getUserIdByName(teacherName);
                if(teacherId == null)
                    throw  new Exception("未找到教师" + teacherName + "的信息");
                result.setTeacherId(teacherId);
            }

            CurriculumClass curriculumClass = new CurriculumClass();
            curriculumClass.setClassSn(cellDoubleToString(sn_temp));
            curriculumClass.setClassName((String) map.get("class_name"));

            String year = (String) map.get("year");
            String term = (String) map.get("term");
            String yearName =  year + term;
            curriculumClass.setClassYear(yearName);

            result.setCurriculumClass(curriculumClass);

            return result;
        }
        catch (ClassCastException ex)
        {
            throw  new ClassCastException("课程" + sn_temp + "转换错误");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


    private Short cellDoubleToShort(Object value) {
        if (value == null)
            return null;
		String temp = value.toString();
		if(temp.isEmpty())
			return null;
        if (value instanceof Double) {
			if(temp.indexOf(".")>-1){
				int flag = temp.indexOf(".");
				temp = temp.substring(0,flag);
			}
            Short result = Short.valueOf(temp).shortValue();
            return result;

        }
        return Short.parseShort(value.toString());
    }


    private String cellDoubleToString(Object value) {
        if (value == null)
            return null;
		String temp = value.toString();
		if(temp.isEmpty())
			return null;
        if (value instanceof Double) {
            long result = Double.valueOf(value.toString()).longValue();
            return "" + result;

        }
        return value.toString();
    }


    private Date cellStringToDate(Object value) {
        if (value == null)
            return null;
		String temp = value.toString();
		if(temp.isEmpty())
			return null;
        if (value instanceof String) {
            String str = value.toString();
            if(str.matches("[0-9]{4}\\.[0-9]{2}"))
            {
                str = str.replace(".","-");
                str += "-01";
            }
            Date date = java.sql.Date.valueOf(str);
            return date;
        }
        return java.sql.Date.valueOf(value.toString());
    }
}
