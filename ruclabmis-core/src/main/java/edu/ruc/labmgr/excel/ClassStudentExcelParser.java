package edu.ruc.labmgr.excel;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.utils.SysUtil;
import org.apache.poi.ss.usermodel.*;

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
            if(id!=null)
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

    public String getFileClassSn(Workbook workbook) {
        assert workbook != null;
        int nos = workbook.getNumberOfSheets();
        if(nos<=0)
            return null;
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(3);
        Cell c = row.getCell(2);
		String sss = c.getRichStringCellValue().getString();
        long result  = Long.parseLong(sss);
        return "" + result;
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
