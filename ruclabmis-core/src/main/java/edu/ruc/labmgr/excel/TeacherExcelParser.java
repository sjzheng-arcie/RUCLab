package edu.ruc.labmgr.excel;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Organization;
import edu.ruc.labmgr.domain.Teacher;
import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.service.OrganizationService;
import edu.ruc.labmgr.service.TitleService;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.Types;

import java.util.Map;


public class TeacherExcelParser extends POIEntityParser<Teacher> {

    @Override
    public Teacher mapToEntity(Map<String, Object> map) {
        Teacher result = new Teacher();

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

            String titleName = (String) map.get("title");
            if(!StringUtils.isNullOrEmpty(titleName))
            {
                TitleService titleService = SysUtil.getBean("titleService", TitleService.class);
                Title title = titleService.selectByName(titleName);
                if(title == null)
                    result.setTitleId(null);
                else
                    result.setTitleId(title.getId());
            }

            String organizationName = (String) map.get("organization");
            if(!StringUtils.isNullOrEmpty(organizationName))
            {
                OrganizationService organizationService = SysUtil.getBean("organizationService", OrganizationService.class);
                Organization organization = organizationService.selectByName(organizationName);
                if(organization == null)
                    result.setOrganizationId(null);
                else
                    result.setOrganizationId(organization.getId());
            }

            //默认密码666666
            result.setPassword("f379eaf3c831b04de153469d1bec345e");
            result.setRoleId(Types.Role.TEACHER.getValue());

            return result;
        }
        catch (ClassCastException ex)
        {
            throw  new ClassCastException("教师" + sn_temp + "转换错误");
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
