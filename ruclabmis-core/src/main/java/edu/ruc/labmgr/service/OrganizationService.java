package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Organization;
import edu.ruc.labmgr.domain.OrganizationCriteria;
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

    public PageInfo<Organization> selectListPage(String name, String  grade,int PageNum){
        OrganizationCriteria criteria = new OrganizationCriteria();
        criteria.setOrderByClause("name");
        OrganizationCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (!StringUtils.isNullOrEmpty(grade))
            ec.andGradeLike("%" + grade + "%");
        return getOrganizationsByCriteria(PageNum, criteria);

    }
    private PageInfo<Organization> getOrganizationsByCriteria(int PageNum,OrganizationCriteria criteria){
        int totalCount = organizationMapper.countByCriteria(criteria);
        PageInfo<Organization> page = new PageInfo<>(totalCount,-1,PageNum);
        List<Organization> data = organizationMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(Organization organization){
        int result = 0;
        result=organizationMapper.insert(organization);
        return result;
    }
    public int update(Organization organization){
        int result = 0;
        result = organizationMapper.updateByPrimaryKey(organization);
        return result;
    }
    public Organization selectByPrimerKey(int id){
        Organization organization = null;
        organization = organizationMapper.selectByPrimaryKey(id);
        return organization;
    }
    public List<Organization> selectAllOrganizations(){
        return organizationMapper.selectByCriteria(null);
    }
    public int delete(int  id){
        int result = 0;
        organizationMapper.deleteByPrimaryKey(id);
        return result;
    }
}
