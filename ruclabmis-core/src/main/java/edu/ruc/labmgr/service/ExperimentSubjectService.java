package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ExperimentSubject;
import edu.ruc.labmgr.domain.ExperimentSubjectCriteria;
import edu.ruc.labmgr.mapper.ExperimentSubjectMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ExperimentSubjectService {
    @Autowired
    private ExperimentSubjectMapper experimentSubjectMapper;

    public PageInfo<ExperimentSubject> selectListPage(String name, int PageNum) {
        ExperimentSubjectCriteria criteria = new ExperimentSubjectCriteria();
        criteria.setOrderByClause("name");
        ExperimentSubjectCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");

        return getExperimentSubjectsByCriteria(PageNum, criteria);

    }

    private PageInfo<ExperimentSubject> getExperimentSubjectsByCriteria(int PageNum, ExperimentSubjectCriteria criteria) {
        int totalCount = experimentSubjectMapper.countByCriteria(criteria);
        PageInfo<ExperimentSubject> page = new PageInfo<>(totalCount, -1, PageNum);
        List<ExperimentSubject> data = experimentSubjectMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(ExperimentSubject experimentSubject) {
        int result = 0;
        result = experimentSubjectMapper.insert(experimentSubject);
        return result;
    }

    public int update(ExperimentSubject experimentSubject) {
        int result = 0;
        result = experimentSubjectMapper.updateByPrimaryKey(experimentSubject);
        return result;
    }

    public ExperimentSubject selectByPrimaryKey(int id) {
        ExperimentSubject ExperimentSubject = null;
        ExperimentSubject = experimentSubjectMapper.selectByPrimaryKey(id);
        return ExperimentSubject;
    }

    public List<ExperimentSubject> selectAllExperimentSubjects() {
        return experimentSubjectMapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            experimentSubjectMapper.deleteByPrimaryKey(id);
        }
    }

}
