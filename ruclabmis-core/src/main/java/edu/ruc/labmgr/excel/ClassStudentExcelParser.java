package edu.ruc.labmgr.excel;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.utils.SysUtil;

import java.util.Map;

public class ClassStudentExcelParser extends POIEntityParser<ClassStudent> {

    @Override
    public ClassStudent mapToEntity(Map<String, Object> map) {
        ClassStudent result = new ClassStudent();

        Object sn_temp = map.get("student_sn");
        if(sn_temp == null)
            return null;
        if(StringUtils.isNullOrEmpty(sn_temp.toString()))
            return null;

        try
        {
            CurriculumClassService curriculumClassService = SysUtil.getBean("curriculumClassService", CurriculumClassService.class);
            Integer id =  curriculumClassService.getStudentIdBySn(cellDoubleToString(sn_temp));
            result.setStudendId(id);

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

    private String cellDoubleToString(Object value) {
        if (value == null)
            return null;
        if (value instanceof Double) {
            long result = Double.valueOf(value.toString()).longValue();
            return "" + result;

        }
        return value.toString();
    }


}
