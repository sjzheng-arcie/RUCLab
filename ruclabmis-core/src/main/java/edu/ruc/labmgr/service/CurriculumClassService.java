package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.CurriculumClassCriteria;
import edu.ruc.labmgr.mapper.ClassStudentMapper;
import edu.ruc.labmgr.mapper.CurriculumClassMapper;
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
public class CurriculumClassService {
    @Autowired
    private CurriculumClassMapper classMapper;
    @Autowired
    private ClassStudentMapper classStudentMapper;

    /**
     * 获得分页的虚拟班级列表
     * @param pageNum
     * @param sn
     * @param name
     * @return
     */
    public PageInfo<CurriculumClass> getPageClasses(int pageNum, String sn, String name) {
        CurriculumClassCriteria criteria = new CurriculumClassCriteria();
        CurriculumClassCriteria.Criteria c = criteria.or();
        if (!StringUtils.isEmpty(sn)) {
            c.andClassSnLike("%" + sn + "%");
        }
        if (!StringUtils.isEmpty(name)) {
            c.andClassNameLike("%" + name + "%");
        }
        return getPageClassByCriteria(pageNum, criteria);
    }

    /**
     * 添加班级
     * @param clazz
     * @return
     */
    public int addCurriculumClass(CurriculumClass clazz){
        classMapper.insert(clazz);
        return clazz.getId();
    }

    /**
     * 添加班级及班级对应的学生。
     * @param clazz
     * @param sids
     */
    public void addCurriculumClass(CurriculumClass clazz,List<Integer> sids){
        int cid = classMapper.insert(clazz);
        if (sids!=null && sids.size()>0){
            for (Integer i : sids){
                ClassStudent cs = new ClassStudent();
                cs.setClassId(cid);
                cs.setStudendId(i);
                classStudentMapper.insertSelective(cs);
            }
        }
    }

    private PageInfo<CurriculumClass> getPageClassByCriteria(int pageNum,
                                                             CurriculumClassCriteria criteria) {
        int totalCount = classMapper.countByCriteria(criteria);

        CurriculumClassCriteria.Criteria c = criteria.getOredCriteria().get(0);
        c.andJoinCurriculum().andJoinUser();

        PageInfo<CurriculumClass> p = new PageInfo<>(totalCount, -1, pageNum);
        List<CurriculumClass> data = classMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(p.getCurrentResult(), p.getPageSize()));
        p.setData(data);
        return p;
    }
}
