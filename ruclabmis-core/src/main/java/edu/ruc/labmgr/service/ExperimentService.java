package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.ExperimentDetailMapper;
import edu.ruc.labmgr.mapper.ExperimentMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Service
public class ExperimentService {
    @Autowired
    private ExperimentMapper experimentMapper;
    @Autowired
    private ExperimentDetailMapper expDetailMapper;
	@Autowired
	private CurriculumClassService curriculumClassService;

    public Experiment getExperiment(Integer id) {
        return experimentMapper.selectByPrimaryKey(id);
    }

    public void addExperiment(Experiment exp) {
        experimentMapper.insert(exp);
    }

	public void addExperimentDetail(int studentId,int curriculumClassId,int experimentId,String path){

		ClassStudent cs = curriculumClassService.getClassStudentInfo(curriculumClassId,studentId);
		int csId = cs.getId();

		List<Map<String,?>> realDetail = expDetailMapper.selectExperimentDetailByStuId(experimentId,studentId);
		if(realDetail!=null && realDetail.size()>0){
			Map<String,?> temp = realDetail.get(0);
			int exDaitaiId =Integer.valueOf(temp.get("id").toString());
			ExperimentDetail  old = new ExperimentDetail();
			old.setId(exDaitaiId);
			old.setReportPath(path);
			expDetailMapper.updateByPrimaryKeySelective(old);

		}else{
			ExperimentDetail exDetail = new ExperimentDetail();
			exDetail.setClassStudentId(csId);
			exDetail.setExperimentId(experimentId);
			exDetail.setReportPath(path);
			expDetailMapper.insert(exDetail);
		}


	}
    public void deleteExperiment(List<Integer> ids) {
        if (ids != null) {
            for (Integer id : ids) {
                Experiment exp = getExperiment(id);
                if (exp != null && exp.getTemplatePath() != null) {
                    String path = exp.getTemplatePath();
                    try {
                        Files.delete(Paths.get(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                experimentMapper.deleteByPrimaryKey(id);
            }
        }
    }

    public void updateExperiment(Experiment exp, String newTempPath) {
        String oldTempPath = exp.getTemplatePath();
        if (oldTempPath != null && newTempPath != null) {
            try {
                exp.setTemplatePath(newTempPath);
                Files.delete(Paths.get(oldTempPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        experimentMapper.updateByPrimaryKey(exp);
    }

    public void updateExperiment(Experiment exp) {
        experimentMapper.updateByPrimaryKeySelective(exp);
    }

    public void updateExperimentDetail(ExperimentDetail detail){
        expDetailMapper.updateByPrimaryKeySelective(detail);
    }

    /**
     * 获得课程对应的实验
     *
     * @param cid
     * @param pageNum
     * @return
     */
    public PageInfo<Experiment> getCurriculumExperiment(int cid, int pageNum) {
        ExperimentCriteria criteria = new ExperimentCriteria();
        criteria.or().andCurriculumIdEqualTo(cid);
        int totalCount = experimentMapper.countByCriteria(criteria);
        PageInfo<Experiment> page = new PageInfo<>(totalCount, -1, pageNum);
        List<Experiment> data = experimentMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public PageInfo<Map<String, ?>> getStudentExperimentDetail(int eid, int pageNum) {
        int totalCount = expDetailMapper.countStudentExperiment(eid);
        PageInfo<Map<String,?>> page = new PageInfo<>(totalCount,-1,pageNum);
        List<Map<String,?>> data = expDetailMapper.selectStudentExperimentsWithRowbound(eid,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }
    //获得学生所有的实验列表
    public PageInfo<Map<String,?>> getStudentAllExperimentDetail(int stuId,int pageNum){
       //TODO
       return null;
    }

    public List<Map<String,?>> getStudentClassExperimentInfo(int vcId,int stuId){
        Map<String,Object> param = new HashMap<>();
        param.put("vcId",vcId);
        param.put("stuId",stuId);
        return experimentMapper.selectStudentClassExpInfo(param);
    }

    public ExperimentDetail getStudentExpDetail(int eid,int stuId){
		//TODO
        ExperimentDetailCriteria criteria = new ExperimentDetailCriteria();
        criteria.or().andExperimentIdEqualTo(eid).andClassStudentIdEqualTo(stuId);
        List<ExperimentDetail> list = expDetailMapper.selectByCriteria(criteria);
        return (list!=null&& list.size()>0) ? list.get(0) : null;
    }
	public ExperimentDetail getStudentExpDetailbyStuId(int eid,int stuId){
		//TODO
		ExperimentDetailCriteria criteria = new ExperimentDetailCriteria();
		criteria.or().andExperimentIdEqualTo(eid).andClassStudentIdEqualTo(stuId);
		List<ExperimentDetail> list = expDetailMapper.selectByCriteria(criteria);
		return (list!=null&& list.size()>0) ? list.get(0) : null;
	}

}
