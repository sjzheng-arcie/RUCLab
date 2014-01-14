package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.ClassStudentMapper;
import edu.ruc.labmgr.mapper.CurriculumScheduleMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-31
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class CurriculumScheduleService {
	@Autowired
	CurriculumScheduleMapper curriculumScheduleMapper;
	@Autowired
	ClassStudentMapper classStudentMapper;

	public void deleteById(int id){
		curriculumScheduleMapper.deleteByPrimaryKey(id);
	}
	public void add(CurriculumSchedule curriculumSchedule){
		curriculumScheduleMapper.insert(curriculumSchedule);
	}
	public CurriculumSchedule getCurriculumScheduleById(int id){
		return  curriculumScheduleMapper.selectByPrimaryKey(id);
	}
	public void update(CurriculumSchedule curriculumSchedule){
		curriculumScheduleMapper.updateByPrimaryKey(curriculumSchedule);
	}
	public boolean ifCurriculumScheduleExistd (CurriculumSchedule curriculumSchedule){
		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
		CurriculumScheduleCriteria.Criteria criteria1 = curriculumScheduleCriteria.createCriteria();

		criteria.andAmPmEqualTo(curriculumSchedule.getAmPm());
		criteria.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
		criteria.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
		criteria.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
		criteria.andClassIdEqualTo(curriculumSchedule.getClassId());

		criteria1.andAmPmEqualTo(curriculumSchedule.getAmPm());
		criteria1.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
		criteria1.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
		criteria1.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
		criteria1.andTeacheridEqualTo(curriculumSchedule.getTeacherid());

		curriculumScheduleCriteria.or(criteria);
		curriculumScheduleCriteria.or(criteria1);

		boolean flag=false;
		if(curriculumScheduleMapper.selectByExample(curriculumScheduleCriteria).size()>0){
			flag=true;
		}
		return flag;
	}
	public PageInfo<CurriculumSchedule> selectListPage(CurriculumScheduleCriteria criteria, int pageNum) {
		int totalCount = curriculumScheduleMapper.countByExample(criteria);
		PageInfo<CurriculumSchedule> page = new PageInfo<>(totalCount, -1, pageNum);
		List<CurriculumSchedule> data = curriculumScheduleMapper.selectByExampleWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
	public List<CurriculumSchedule> getCurriculumScheduleList(){
		return curriculumScheduleMapper.selectByExample(null);
	}
	public List<CurriculumSchedule> getCurriculumScheduleListGroupByWeek(CurriculumScheduleCriteria criteria){
		return curriculumScheduleMapper.getAllCurriculumNameList(criteria);
	}
	public List<Integer> getRoomListIdList(CurriculumScheduleCriteria criteria){
		List<CurriculumSchedule> curriculumScheduleList=curriculumScheduleMapper.selectByExample(criteria);
		List<Integer> roomIdList=new ArrayList<>();
		for(int i=0;i<curriculumScheduleList.size();i++){
			if(curriculumScheduleList.get(i).getRoomId()!=null){
				roomIdList.add(curriculumScheduleList.get(i).getRoomId());
			}
		}
		return roomIdList;
	}
	public List<CurriculumSchedule> getCurriculumScheduleList(CurriculumScheduleCriteria criteria){
		List<CurriculumSchedule> curriculumScheduleList=curriculumScheduleMapper.selectByExample(criteria);
		return curriculumScheduleList;
	}

	public List<Integer> getClassIdListByStudentId(int id){
		List<Integer> classList=new ArrayList<>();
		ClassStudentCriteria classStudentCriteria = new ClassStudentCriteria();
		ClassStudentCriteria.Criteria criteria= classStudentCriteria.createCriteria();
		criteria.andStudentIdEqualTo(id);
		List<ClassStudent> classStudentList=classStudentMapper.selectByCriteria(classStudentCriteria);

		for(int i=0;i<classStudentList.size();i++){
			classList.add(i,classStudentList.get(i).getClassId());
		}
		return classList;


	}
	public String getCurriculumScheduleBy(){



		return null;
	}
}
