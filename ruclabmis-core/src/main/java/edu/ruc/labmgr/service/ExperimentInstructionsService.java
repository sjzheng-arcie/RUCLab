package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ExperimentInstructions;
import edu.ruc.labmgr.domain.ExperimentInstructions;
import edu.ruc.labmgr.domain.ExperimentInstructionsCriteria;
import edu.ruc.labmgr.mapper.ExperimentInstructionsMapper;
import edu.ruc.labmgr.mapper.ExperimentInstructionsMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ExperimentInstructionsService {
    @Autowired
    private ExperimentInstructionsMapper mapper;

    public PageInfo<ExperimentInstructions> selectListPage(Integer curriculumId,int PageNum) {
        ExperimentInstructionsCriteria criteria = new ExperimentInstructionsCriteria();
        criteria.setOrderByClause("curriculum_id");
        ExperimentInstructionsCriteria.Criteria ec = criteria.createCriteria();
        if (curriculumId != null)
            ec.andCurriculumIdEqualTo(curriculumId);

        return getExperimentInstructionsByCriteria(PageNum, criteria);
    }

    private PageInfo<ExperimentInstructions> getExperimentInstructionsByCriteria(int PageNum, ExperimentInstructionsCriteria criteria) {
        int totalCount = mapper.countByCriteria(criteria);
        PageInfo<ExperimentInstructions> page = new PageInfo<>(totalCount, -1, PageNum);
        List<ExperimentInstructions> data = mapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(ExperimentInstructions experimentInstructions) {
        int result = 0;
        result = mapper.insert(experimentInstructions);
        return result;
    }

    public int update(ExperimentInstructions experimentInstructions) {
        int result = 0;
        result = mapper.updateByPrimaryKey(experimentInstructions);
        return result;
    }

    public ExperimentInstructions selectByPrimaryKey(int id) {
        ExperimentInstructions ExperimentInstructions = null;
        ExperimentInstructions = mapper.selectByPrimaryKey(id);
        return ExperimentInstructions;
    }

    public List<ExperimentInstructions> selectAllExperimentInstructionss() {
        return mapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            mapper.deleteByPrimaryKey(id);
        }
    }
}
