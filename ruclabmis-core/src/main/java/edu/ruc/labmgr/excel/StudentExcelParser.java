package edu.ruc.labmgr.excel;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Student;
import edu.ruc.labmgr.utils.Types;

import java.util.Map;


public class StudentExcelParser extends POIEntityParser<Student> {

    @Override
    public Student mapToEntity(Map<String, Object> map) {
        Student result = new Student();

        Object sn_temp = map.get("sn");
        if(sn_temp == null)
            return null;
        if(StringUtils.isNullOrEmpty(sn_temp.toString()))
            return null;

        try
        {
            result.setSn(cellDoubleToString(sn_temp));
            result.setName((String) map.get("name"));

            boolean sex = false;
            String strSex = (String) map.get("name");
            if( strSex == "男")
                sex = true;
            result.setSex(sex);

            //默认密码666666
            result.setPassword("f379eaf3c831b04de153469d1bec345e");
            result.setRoleId(Types.Role.STUDENT.getValue());

            return result;
        }
        catch (ClassCastException ex)
        {
            throw  new ClassCastException("学生" + sn_temp + "转换错误");
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
