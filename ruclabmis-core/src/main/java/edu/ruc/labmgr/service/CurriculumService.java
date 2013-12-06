package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumCriteria;
import edu.ruc.labmgr.mapper.CurriculumMapper;
import org.apache.commons.lang3.StringUtils;
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

    public List<Curriculum> getCurriculum(String name) {
        CurriculumCriteria criteria = new CurriculumCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.or().andNameLike(name).andJoinMajor().andJoinTeacher();
        } else {
            criteria.or().andJoinMajor().andJoinTeacher();
        }
        return curriculumMapper.selectByCriteria(criteria);
    }

}
