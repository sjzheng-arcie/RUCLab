package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.*;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@SuppressWarnings("ALL")
@Service
public class CurriculumClassService {
    @Autowired
    CurriculumClassMapper classMapper;
    @Autowired
    ClassStudentMapper classStudentMapper;
    @Autowired
    CurriculumMapper curriculumMapper;
    @Autowired
    UserMapper userMapper;
	@Autowired
	BbsSessionMapper bbsSessionMapper;
	@Autowired
	CurriculumClassMapper curriculumClassMapper;

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
	public PageInfo<CurriculumClass> getPageClassbyPageNumUseQuery(String sn,String name,int pageNum, int id, Types.Role role) {
		CurriculumClassCriteria criteria = new CurriculumClassCriteria();
		CurriculumClassCriteria.Criteria c = criteria.or();
		if (!StringUtils.isEmpty(sn)) {
			c.andClassSnLike("%" + sn + "%");
		}
		if (!StringUtils.isEmpty(name)) {
			c.andClassNameLike("%" + name + "%");
		}
		return getPageClassByCriteriaAndUid(pageNum, criteria, id, role);
	}
    public PageInfo<CurriculumClass> getPageClassbyPageNumUseQuery(String sn,String name,int pageNum, int id, Types.Role role, Integer curriculumId) {
        CurriculumClassCriteria criteria = new CurriculumClassCriteria();
        CurriculumClassCriteria.Criteria c = criteria.or();
        if (!StringUtils.isEmpty(sn)) {
            c.andClassSnLike("%" + sn + "%");
        }
        if (!StringUtils.isEmpty(name)) {
            c.andClassNameLike("%" + name + "%");
        }
        if (curriculumId != null && curriculumId >0 ) {
            c.andIdEqualTo(curriculumId);
        }
        return getPageClassByCriteriaAndUid(pageNum, criteria, id, role);
    }
	public List<CurriculumClass> getAllCurriculumClass() {
		CurriculumClassCriteria criteria = new CurriculumClassCriteria();
		CurriculumClassCriteria.Criteria c = criteria.or();
		c.andJoinCurriculum().andJoinUser();
		return curriculumClassMapper.selectByCriteria(criteria);
	}
    /**
     * @param id
     * @return
     * @author:sjzheng
     */
    public PageInfo<CurriculumClass> getPageClassbyPageNum(int pageNum, int id, Types.Role role) {
        CurriculumClassCriteria criteria = new CurriculumClassCriteria();
        CurriculumClassCriteria.Criteria c = criteria.or();
        return getPageClassByCriteriaAndUid(pageNum, criteria, id, role);
    }

    public PageInfo<CurriculumClass> getPageCourseClassbyPageNum(int pageNum, int id, Integer curriculumId, Types.Role role) {
        CurriculumClassCriteria criteria = new CurriculumClassCriteria();

        CurriculumClassCriteria.Criteria c = criteria.or();
        if(curriculumId != null && curriculumId > 0 )
            c.andIdEqualTo(curriculumId);

        return getPageClassByCriteriaAndUid(pageNum, criteria, id, role);
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

    public ClassStudent getClassStudentInfo(int cid,int stuId){
        ClassStudentCriteria criteria = new ClassStudentCriteria();
        criteria.or().andClassIdEqualTo(cid).andStudentIdEqualTo(stuId);
        List<ClassStudent> list = classStudentMapper.selectByCriteria(criteria);
        return (list!=null && list.size()>0) ? list.get(0) : null;
    }

    public PageInfo<Student> getPageClassStudent(int cid, String sn, String name, String major,int pageNum){
        ClassStudentCriteria criteria = new ClassStudentCriteria();
        ClassStudentCriteria.Criteria c = criteria.or();
        c.andJoinUser().andJoinStudent().andJoinMajor().andClassIdEqualTo(cid);
        if (StringUtils.isNotEmpty(sn))
            c.andStudentSnLike("%" + sn + "%");
        if (StringUtils.isNotEmpty(name))
            c.andStudentNameLike("%" + name + "%");
        if (StringUtils.isNotEmpty(major))
            c.andStudentMajorLike("%" + major + "%");
        int totalCount = classStudentMapper.countByCriteria(criteria);
        PageInfo<Student> page = new PageInfo<>(totalCount,-1,pageNum);
        List<Student> data = classStudentMapper.selectByCriteriaWithStudentWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }

    public PageInfo<Map<String,?>> getPageClassStudentInfo(int cid, String sn, String name, String major,int pageNum){
        Map<String,Object> param = new HashMap<>();
        if (sn!=null)
            param.put("sn","%"+sn+"%");
        if (name!=null)
            param.put("name","%"+name+"%");
        if (major!=null)
            param.put("major","%"+major+"%");
        param.put("cid",cid);
        int totalCount = classStudentMapper.countClassStudentInfo(param);
        PageInfo<Map<String,?>> page = new PageInfo<>(totalCount,-1,pageNum);
        List<Map<String,?>> data = classStudentMapper.selectClassStudentInfo(param,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }

    /**
     * 选出没有在某个班级的学生
     *
     * @param cid
     * @param sn
     * @param name
     * @param major
     * @param pageNum
     * @return
     */
    public PageInfo<Student> getStudentsNotInClass(int cid, String sn, String name, String major, int pageNum) {
        ClassStudentCriteria criteria = new ClassStudentCriteria();
        ClassStudentCriteria.Criteria c = criteria.or();
        c.andJoinStudent().andJoinMajor().andStudentNotInClass(cid);
        if (StringUtils.isNotEmpty(sn))
            c.andStudentSnLike("%" + sn + "%");
        if (StringUtils.isNotEmpty(name))
            c.andStudentNameLike("%" + name + "%");
        if (StringUtils.isNotEmpty(major))
            c.andStudentMajorLike("%" + major + "%");
        int totalCount = classStudentMapper.countStudentNotInClass(criteria);
        PageInfo<Student> result = new PageInfo<>(totalCount, -1, pageNum);
        List<Student> students = classStudentMapper.selectStudentNotInClassWithRowbounds(criteria,
                new RowBounds(result.getCurrentResult(), result.getPageSize()));
        result.setData(students);
        return result;
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

		addBBSection(cid,clazz);

    }

    public void updateClassStudentScore(ClassStudent classStudent){
       if (classStudent.getId()!=null){
           classStudentMapper.updateByPrimaryKeySelective(classStudent);
       }
    }

	/**
	 * 创建班级的时候添加版块
	 * @param curriculumClassId
	 * @param clazz
	 * @auhtor zsj
	 */
	private void addBBSection(int curriculumClassId,CurriculumClass clazz){
		BbsSession bbsSection = new BbsSession();
		bbsSection.setId(curriculumClassId);
		int curricumid = clazz.getId();
		Curriculum cm = curriculumMapper.selectByPrimaryKey(curricumid);
		bbsSection.setDescription(cm.getName()+"-"+clazz.getClassName()+"-"+clazz.getClassYear());
		bbsSection.setReplycount(0);
		bbsSection.setTopiccount(0);
		bbsSessionMapper.insert(bbsSection);
	}

    /**
     * 添加学生到已有的班级
     * @param vcId
     * @param stIds
     */
    public void addStudentToClass(int vcId,List<Integer> stIds){
        for (Integer i : stIds) {
            ClassStudent cs = new ClassStudent();
            cs.setClassId(vcId);
            cs.setStudendId(i);
            classStudentMapper.insertSelective(cs);
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
				bbsSessionMapper.deleteByPrimaryKey(i);
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
     * @param pageNum
     * @param criteria
     * @param id
     * @return
     */
    private PageInfo<CurriculumClass> getPageClassByCriteriaAndUid(int pageNum,
                                                                   CurriculumClassCriteria criteria, int id, Types.Role role) {


        CurriculumClassCriteria.Criteria c = criteria.getOredCriteria().get(0);

		List<CurriculumClass> data= new ArrayList<>();
        if (role == Types.Role.STUDENT) {
            c.andJoinCurriculum().andJoinClassStudent().andStudentIdEqual(id).andJoinCsUser();
			int totalCount = classMapper.countByCriteriaByJoinIncludeCS(criteria);
			PageInfo<CurriculumClass> p = new PageInfo<>(totalCount, -1, pageNum);
			 data = classMapper.selectByCriteriaAndClsStudentWithRowbounds(criteria,
					new RowBounds(p.getCurrentResult(), p.getPageSize()));
			p.setData(ChangeNameFromStuToTea(data));
			return p;

        } else if (role == Types.Role.ADMIN) {
            c.andJoinCurriculum().andJoinUser();
			int totalCount = classMapper.countByCriteriaJoinNotIncludeCS(criteria);
			PageInfo<CurriculumClass> p = new PageInfo<>(totalCount, -1, pageNum);
			 data = classMapper.selectByCriteriaWithRowbounds(criteria,
					new RowBounds(p.getCurrentResult(), p.getPageSize()));
			p.setData(data);
			return p;

        } else {
          //  c.andJoinCurriculum().andJoinClassStudent().andJoinUser().andUserIdEqual(id);
			c.andJoinCurriculum().andJoinUser().andUserIdEqual(id);
			int totalCount = classMapper.countByCriteriaJoinNotIncludeCS(criteria);
			PageInfo<CurriculumClass> p = new PageInfo<>(totalCount, -1, pageNum);
			 data = classMapper.selectByCriteriaWithRowbounds(criteria,
					new RowBounds(p.getCurrentResult(), p.getPageSize()));
			p.setData(data);
			return p;
        }

    }
	public List<CurriculumClass> getPrivateCurricumClasses(int id, Types.Role role){
		CurriculumClassCriteria criteria = new CurriculumClassCriteria();
		CurriculumClassCriteria.Criteria c = criteria.or();
		List<CurriculumClass> data = new ArrayList<CurriculumClass>();

		if (role == Types.Role.STUDENT) {
			c.andJoinCurriculum().andJoinClassStudent().andStudentIdEqual(id).andJoinCsUser();
			data =classMapper.selectByCriteriaAndClsStudent(criteria);

		} else if (role == Types.Role.ADMIN) {
			c.andJoinCurriculum().andJoinUser();
			data =classMapper.selectByCriteria(criteria);

		} else {
			c.andJoinCurriculum().andJoinUser().andUserIdEqual(id);
			data =classMapper.selectByCriteria(criteria);

		}
		return  data;
	}
	public List<Integer> getPrivateSessionIds(int id, Types.Role role){
		List<CurriculumClass> data = getPrivateCurricumClasses(id,role);
		List<Integer> sessionIds = new ArrayList<Integer>();
		for(CurriculumClass cc : data){
			sessionIds.add(cc.getId());
		}
		return sessionIds;
	}
	public List<Integer> getPrivateCurricumClassIds(int id, Types.Role role){
		List<Integer> CurricumIds = new ArrayList<Integer>();
		List<CurriculumClass> data = getPrivateCurricumClasses(id,role);
		for(CurriculumClass cc : data){
			CurricumIds.add(cc.getId());
		}
		return  CurricumIds;

	}
	public List<Integer> getPrivateCurricumIds(int id, Types.Role role){
		List<Integer> CurricumIds = new ArrayList<Integer>();
		List<CurriculumClass> data = getPrivateCurricumClasses(id, role);
		for(CurriculumClass cc : data){
			CurricumIds.add(cc.getId());
		}
		return  CurricumIds;

	}
	public List<CurriculumClass> getClassByCriteriaUserIdAndRole(int id, Types.Role role) {
		CurriculumClassCriteria criteria = new CurriculumClassCriteria();
		CurriculumClassCriteria.Criteria c = criteria.or();
		List<CurriculumClass> data = new ArrayList<CurriculumClass>();
		if (role == Types.Role.STUDENT) {
			c.andJoinCurriculum().andJoinClassStudent().andStudentIdEqual(id).andJoinCsUser();
			data =classMapper.selectByCriteriaAndClsStudent(criteria);

		} else if (role == Types.Role.ADMIN) {
			c.andJoinCurriculum().andJoinUser();
			 data =classMapper.selectByCriteria(criteria);

		} else {
			c.andJoinCurriculum().andJoinUser().andUserIdEqual(id);
			data =classMapper.selectByCriteria(criteria);

		}

		if (role == Types.Role.STUDENT)
			ChangeNameFromStuToTea(data);

		return data;
	}

    private List<CurriculumClass> ChangeNameFromStuToTea(List<CurriculumClass> data) {
        if (data == null)
            return data;
        for (CurriculumClass cc : data) {
            int curricumId = cc.getId();
            Curriculum cum = curriculumMapper.selectByPrimaryKey(curricumId);
            int teacheId = cum.getTeacherId();
            User user = userMapper.selectByPrimaryKey(teacheId);
            cc.setTeacherName(user.getName());
        }
        return data;
    }
}
