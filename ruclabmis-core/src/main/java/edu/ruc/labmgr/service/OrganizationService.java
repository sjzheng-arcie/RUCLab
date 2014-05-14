package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Organization;
import edu.ruc.labmgr.domain.OrganizationCriteria;
import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.domain.TitleCriteria;
import edu.ruc.labmgr.mapper.OrganizationMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    public List<Organization> selectListPage() {
        OrganizationCriteria criteria = new OrganizationCriteria();
        criteria.setOrderByClause("parent_id");
        return organizationMapper.selectByCriteria(criteria);
    }

    public int insert(Organization organization) {
        int result = 0;
        result = organizationMapper.insert(organization);
        return result;
    }

    public int update(Organization organization) {
        int result = 0;
        result = organizationMapper.updateByPrimaryKey(organization);
        return result;
    }

    public Organization selectByPrimaryKey(int id) {
        Organization organization = null;
        organization = organizationMapper.selectByPrimaryKey(id);
        return organization;
    }


    public  Organization selectByName(String name) {
        OrganizationCriteria criteria = new OrganizationCriteria();
        OrganizationCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameEqualTo(name);

        List<Organization> organizations = organizationMapper.selectByCriteria(criteria);
        if(organizations.size() > 0)
            return organizations.get(0);
        else
            return null;
    }

    public List<Organization> selectAllOrganizations() {
        return organizationMapper.selectByCriteria(null);
    }

    public void delete(List<Integer> equipmentIds) {
        for (int id : equipmentIds){
			organizationMapper.deleteByPrimaryKey(id);

		}
    }
	public void delete (Integer id ){
		organizationMapper.deleteByPrimaryKey(id);
	}
}
