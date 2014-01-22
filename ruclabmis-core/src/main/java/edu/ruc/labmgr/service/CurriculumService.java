package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumCriteria;
import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.domain.ExperimentCriteria;
import edu.ruc.labmgr.mapper.CurriculumMapper;
import edu.ruc.labmgr.mapper.ExperimentMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@SuppressWarnings("ALL")
@Service
public class CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    public List<Curriculum> getCurriculum(String name,int teacherId,boolean ifteacher) {
        CurriculumCriteria criteria = new CurriculumCriteria();

        if (!StringUtils.isNullOrEmpty(name)) {
			if(ifteacher)
            	criteria.or().andNameLike(name).andJoinMajor().andJoinTeacher().andTeacherIdEqualTo(teacherId);
			else
				criteria.or().andNameLike(name).andJoinMajor().andJoinTeacher();
        } else {
			if (ifteacher)
            	criteria.or().andJoinMajor().andJoinTeacher().andTeacherIdEqualTo(teacherId);
			else
				criteria.or().andJoinMajor().andJoinTeacher();
        }
        return curriculumMapper.selectByCriteria(criteria);
    }

    public Curriculum getCurriculum(int cid){
        return curriculumMapper.selectByPrimaryKey(cid);
    }

//    public PageInfo<Experiment> getExperimentbyClassId(int curriculumId ,int pageNum){
//        ExperimentCriteria criteria  = new ExperimentCriteria();
//        criteria.or().andJoinExperimentInstuction().andJoinCurriculum().andCurricumIdEqual(curriculumId);
//        int totalCount = experimentMapper.countByCriteria(criteria);
//        PageInfo<Experiment> pageInfo = new PageInfo<>(totalCount,-1,pageNum);
//        List<Experiment> datas = experimentMapper.selectByCriteriaWithRowbounds(criteria,
//                new RowBounds(pageInfo.getCurrentResult(),pageInfo.getPageSize()));
//        pageInfo.setData(datas);
//        return pageInfo;
//
//    }

    public PageInfo<Curriculum> selectListPage(String name, Integer majorId, int PageNum) {
        CurriculumCriteria criteria = new CurriculumCriteria();
        criteria.setOrderByClause("c_major_id");
        CurriculumCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (majorId != null)
            ec.andMajorIdEqualTo(majorId);

        ec.andJoinMajor().andJoinTeacher();
        return getCurriculumByCriteria(PageNum, criteria);
    }

    private PageInfo<Curriculum> getCurriculumByCriteria(int PageNum, CurriculumCriteria criteria) {
        int totalCount = curriculumMapper.countByCriteria(criteria);
        PageInfo<Curriculum> page = new PageInfo<>(totalCount, -1, PageNum);
        List<Curriculum> data = curriculumMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(Curriculum curriculum) {
        int result = 0;
        result = curriculumMapper.insert(curriculum);
        return result;
    }

    public int update(Curriculum curriculum) {
        int result = 0;
        result = curriculumMapper.updateByPrimaryKey(curriculum);
        return result;
    }

    public Curriculum selectByPrimaryKey(int id) {
        Curriculum Curriculum = null;
        Curriculum = curriculumMapper.selectByPrimaryKey(id);
        return Curriculum;
    }

    public List<Curriculum> selectAllCurriculums() {
        CurriculumCriteria criteria = new CurriculumCriteria();
        criteria.setOrderByClause("c_major_id");
        CurriculumCriteria.Criteria ec = criteria.createCriteria();
        ec.andJoinMajor().andJoinTeacher();

        return curriculumMapper.selectByCriteria(criteria);
    }

    public List<Curriculum> selectCurriculumsById(List<Integer> ids) {
        if(ids.size() <= 0)
            return null;

        CurriculumCriteria criteria = new CurriculumCriteria();
        criteria.setOrderByClause("c_name");
        CurriculumCriteria.Criteria ec = criteria.createCriteria();
        ec.andJoinMajor().andJoinTeacher();
        ec.andIdIn(ids);

        return curriculumMapper.selectByCriteria(criteria);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            curriculumMapper.deleteByPrimaryKey(id);
        }
    }
}
