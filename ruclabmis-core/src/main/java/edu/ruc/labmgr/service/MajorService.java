package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.domain.MajorCriteria;
import edu.ruc.labmgr.mapper.MajorMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class MajorService {
    @Autowired
    private MajorMapper majorMapper;

    public PageInfo<Major> selectListPage(String name,int PageNum) {
        MajorCriteria criteria = new MajorCriteria();
        criteria.setOrderByClause("name");
        MajorCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        return getMajorByCriteria(PageNum, criteria);
    }

    private PageInfo<Major> getMajorByCriteria(int PageNum, MajorCriteria criteria) {
        int totalCount = majorMapper.countByCriteria(criteria);
        PageInfo<Major> page = new PageInfo<>(totalCount, -1, PageNum);
        List<Major> data = majorMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(Major major) {
        int result = 0;
        result = majorMapper.insert(major);
        return result;
    }

    public int update(Major major) {
        int result = 0;
        result = majorMapper.updateByPrimaryKey(major);
        return result;
    }

    public Major selectByPrimaryKey(int id) {
        Major Major = null;
        Major = majorMapper.selectByPrimaryKey(id);
        return Major;
    }

    public List<Major> selectAllMajors() {
        return majorMapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            majorMapper.deleteByPrimaryKey(id);
        }
    }

}
