package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.CurriculumExamination;
import edu.ruc.labmgr.domain.CurriculumExaminationCriteria;
import edu.ruc.labmgr.mapper.CurriculumExaminationMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CurriculumExaminationService {
    @Autowired
    private CurriculumExaminationMapper mapper;

    public PageInfo<CurriculumExamination> selectListPage(String name,int PageNum) {
        CurriculumExaminationCriteria criteria = new CurriculumExaminationCriteria();
        criteria.setOrderByClause("curriculum_name");
        CurriculumExaminationCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andnameLike(name);

        return getCurriculumExaminationByCriteria(PageNum, criteria);
    }

    private PageInfo<CurriculumExamination> getCurriculumExaminationByCriteria(int PageNum, CurriculumExaminationCriteria criteria) {
        int totalCount = mapper.countByCriteria(criteria);
        PageInfo<CurriculumExamination> page = new PageInfo<>(totalCount, -1, PageNum);
        List<CurriculumExamination> data = mapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(CurriculumExamination examination) {
        int result = 0;
        result = mapper.insert(examination);
        return result;
    }

    public int insertOrUpdate(CurriculumExamination examination) {
        int result = 0;
        CurriculumExaminationCriteria criteria = new CurriculumExaminationCriteria();
        CurriculumExaminationCriteria.Criteria ec = criteria.createCriteria();
        ec.andIdEqualTo(examination.getId());
        ec.andDocumentNameIsNotNull();
        ec.andDocumentPathIsNotNull();
        int currCount = mapper.countByCriteria( criteria );
        if(currCount == 1)
            result = mapper.updateByPrimaryKey(examination);
        else
            result = mapper.insert(examination);

        return result;
    }

    public int update(CurriculumExamination examination) {
        int result = 0;
        result = mapper.updateByPrimaryKey(examination);
        return result;
    }

    public CurriculumExamination selectByPrimaryKey(int id) {
        CurriculumExamination CurriculumExamination = null;
        CurriculumExamination = mapper.selectByPrimaryKey(id);
        return CurriculumExamination;
    }

    public List<CurriculumExamination> selectAllCurriculumExaminations() {
        return mapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            mapper.deleteByPrimaryKey(id);
        }
    }
}
