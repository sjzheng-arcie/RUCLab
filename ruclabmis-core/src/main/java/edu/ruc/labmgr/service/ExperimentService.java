package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.domain.ExperimentCriteria;
import edu.ruc.labmgr.mapper.ExperimentMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Service
public class ExperimentService {
    @Autowired
    private ExperimentMapper experimentMapper;

    public Experiment getExperiment(Integer id){
       return experimentMapper.selectByPrimaryKey(id);
    }

    public void addExperiment(Experiment exp) {
        experimentMapper.insert(exp);
    }

    public void deleteExperiment(List<Integer> ids){
       if (ids!=null){
           for(Integer id : ids){
               Experiment exp = getExperiment(id);
               if (exp!=null && exp.getTemplatePath()!=null){
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

    public void updateExperiment(Experiment exp,String newTempPath){
        String oldTempPath = exp.getTemplatePath();
        if (oldTempPath!=null && newTempPath!=null){
            try{
                exp.setTemplatePath(newTempPath);
                Files.delete(Paths.get(oldTempPath));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        experimentMapper.updateByPrimaryKey(exp);
    }

    /**
     * 获得课程对应的实验
     * @param cid
     * @param pageNum
     * @return
     */
    public PageInfo<Experiment> getCurriculumExperiment(int cid, int pageNum) {
        ExperimentCriteria criteria = new ExperimentCriteria();
        criteria.or().andCurriculumIdEqualTo(cid);
        int totalCount = experimentMapper.countByExample(criteria);
        PageInfo<Experiment> page = new PageInfo<>(totalCount,-1,pageNum);
        List<Experiment> data = experimentMapper.selectByExampleWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }
}
