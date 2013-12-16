package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumCriteria;
import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.domain.ExperimentCriteria;
import edu.ruc.labmgr.mapper.CurriculumMapper;
import edu.ruc.labmgr.mapper.ExperimentMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Service
public class CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;

	@Autowired
	private ExperimentMapper experimentMapper;

    public List<Curriculum> getCurriculum(String name) {
        CurriculumCriteria criteria = new CurriculumCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.or().andNameLike(name).andJoinMajor().andJoinTeacher();
        } else {
            criteria.or().andJoinMajor().andJoinTeacher();
        }
        return curriculumMapper.selectByCriteria(criteria);
    }

    public Curriculum getCurriculum(int cid){
        return curriculumMapper.selectByPrimaryKey(cid);
    }

	public PageInfo<Experiment> getExperimentbyClassId(int curriculumId ,int pageNum){

		ExperimentCriteria criteria  = new ExperimentCriteria();
		criteria.or().andJoinExperimentInstuction().andJoinCurriculum().andCurricumIdEqual(curriculumId);
		int totalCount = experimentMapper.countByCriteria(criteria);
		PageInfo<Experiment> pageInfo = new PageInfo<>(totalCount,-1,pageNum);
		List<Experiment> datas = experimentMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(pageInfo.getCurrentResult(),pageInfo.getPageSize()));
		pageInfo.setData(datas);
		return pageInfo;

	}

}
