package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.ClassStudentMapper;
import edu.ruc.labmgr.mapper.CurriculumClassMapper;
import edu.ruc.labmgr.mapper.CurriculumMapper;
import edu.ruc.labmgr.mapper.UserMapper;
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
	@Autowired
	private CurriculumMapper curriculumMapper;
	@Autowired
	private UserMapper userMapper;

    /**
     * 获得分页的虚拟班级列表
     *
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
	 *
	 * @param id
	 * @return
	 * @author:sjzheng
	 */
	public PageInfo<CurriculumClass> getPageClassbyPageNum(int pageNum,int id,boolean flag){
		CurriculumClassCriteria criteria = new CurriculumClassCriteria();
		CurriculumClassCriteria.Criteria c = criteria.or();
		return getPageClassByCriteriaAndUid(pageNum, criteria, id, flag);
	}

    public CurriculumClass getVirtualClass(int cid) {
        return classMapper.selectByPrimaryKey(cid);
    }

    public List<Student> getClassStudents(int cid, String sn, String name, String major) {
        ClassStudentCriteria criteria = new ClassStudentCriteria();
        ClassStudentCriteria.Criteria c = criteria.or();
        c.andJoinUser().andJoinStudent().andJoinMajor().andClassIdEqualTo(cid);
        if (StringUtils.isNotEmpty(sn))
            c.andStudentSnLike("%" + sn + "%");
        if (StringUtils.isNotEmpty(name))
            c.andStudentNameLike("%" + name + "%");
        if (StringUtils.isNotEmpty(major))
            c.andStudentMajorLike("%" + major + "%");
        return classStudentMapper.selectByCriteriaWithStudent(criteria);
    }

    /**
     * 添加班级
     *
     * @param clazz
     * @return
     */
    public int addCurriculumClass(CurriculumClass clazz) {
        classMapper.insert(clazz);
        return clazz.getId();
    }

    /**
     * 添加班级及班级对应的学生。
     *
     * @param clazz
     * @param sids
     */
    public void addCurriculumClass(CurriculumClass clazz, List<Integer> sids) {
        classMapper.insert(clazz);
        int cid = clazz.getId();
        if (sids != null && sids.size() > 0) {
            for (Integer i : sids) {
                ClassStudent cs = new ClassStudent();
                cs.setClassId(cid);
                cs.setStudendId(i);
                classStudentMapper.insertSelective(cs);
            }
        }
    }

    public void updateCurriculumClass(CurriculumClass clazz) {
        if (clazz.getId() != null) {
            classMapper.updateByPrimaryKey(clazz);
        }
    }

    public void deleteClass(int[] ids) {
        if (ids != null && ids.length > 0) {
            for (int i : ids) {
                classMapper.deleteByPrimaryKey(i);
            }
        }
    }

    public void deleteClassStudent(int vcid, int[] stIds) {
        for (int sid : stIds) {
            ClassStudentCriteria criteria = new ClassStudentCriteria();
            criteria.or().andClassIdEqualTo(vcid).andStudentIdEqualTo(sid);
            classStudentMapper.deleteByCriteria(criteria);
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

	/**
	 *
 	 * @param pageNum
	 * @param criteria
	 * @param id
	 * @return
	 */
	private PageInfo<CurriculumClass> getPageClassByCriteriaAndUid(int pageNum,
															 CurriculumClassCriteria criteria,int id,boolean ifstudent) {
		int totalCount = classMapper.countByCriteria(criteria);

		CurriculumClassCriteria.Criteria c = criteria.getOredCriteria().get(0);
		PageInfo<CurriculumClass> p = new PageInfo<>(totalCount, -1, pageNum);
		if(ifstudent){
			c.andJoinCurriculum().andJoinClassStudent().andStudentIdEqual(id).andJoinCsUser();
			List<CurriculumClass> data = classMapper.selectByCriteriaAndClsStudentWithRowbounds(criteria,
					new RowBounds(p.getCurrentResult(), p.getPageSize()));
			p.setData(ChangeNameFromStuToTea(data));
		}else{
			c.andJoinCurriculum().andJoinUser().andUserIdEqual(id);
			List<CurriculumClass> data = classMapper.selectByCriteriaWithRowbounds(criteria,
					new RowBounds(p.getCurrentResult(), p.getPageSize()));
			p.setData(data);
		}

		return p;
	}
	private List<CurriculumClass> ChangeNameFromStuToTea(List<CurriculumClass> data){
		if(data==null)
			return data;
		for(CurriculumClass cc:data){
			int curricumId = cc.getCurriculumId();
			Curriculum cum =curriculumMapper.selectByPrimaryKey(curricumId);
			int teacheId = cum.getTeacherId();
			User user= userMapper.selectByPrimaryKey(teacheId);
			cc.setTeacherName(user.getName());
		}
		return data;
	}
}
