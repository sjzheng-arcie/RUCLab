package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.RelatedResources;
import edu.ruc.labmgr.domain.RelatedResourcesCriteria;
import edu.ruc.labmgr.mapper.RelatedResourcesMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class RelatedResourceService {
    @Autowired
    private RelatedResourcesMapper mapper;

    public PageInfo<RelatedResources> selectListPage(String name, Integer curriculumId, Integer userId, int PageNum) {
        RelatedResourcesCriteria criteria = new RelatedResourcesCriteria();
        criteria.setOrderByClause("name");
        RelatedResourcesCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (curriculumId != null)
            ec.andCurriculumIdEqualTo(curriculumId);
        if (userId != null)
            ec.andUploadPersonEqualTo(userId);

        return getRelatedResourcessByCriteria(PageNum, criteria);
    }

    private PageInfo<RelatedResources> getRelatedResourcessByCriteria(int PageNum, RelatedResourcesCriteria criteria) {
        int totalCount = mapper.countByCriteria(criteria);
        PageInfo<RelatedResources> page = new PageInfo<>(totalCount, -1, PageNum);
        List<RelatedResources> data = mapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(RelatedResources relatedResource) {
        int result = 0;
        result = mapper.insert(relatedResource);
        return result;
    }

    public int update(RelatedResources relatedResource) {
        int result = 0;
        result = mapper.updateByPrimaryKey(relatedResource);
        return result;
    }

    public RelatedResources selectByPrimaryKey(int id) {
        RelatedResources RelatedResources = null;
        RelatedResources = mapper.selectByPrimaryKey(id);
        return RelatedResources;
    }

    public List<RelatedResources> selectAllRelatedResourcess() {
        return mapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            mapper.deleteByPrimaryKey(id);
        }
    }
	public void  delete(int id){
		mapper.deleteByPrimaryKey(id);
	}


}
