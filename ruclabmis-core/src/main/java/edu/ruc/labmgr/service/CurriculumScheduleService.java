package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.domain.CurriculumClassCriteria;
import edu.ruc.labmgr.domain.CurriculumSchedule;
import edu.ruc.labmgr.domain.CurriculumScheduleCriteria;
import edu.ruc.labmgr.mapper.CurriculumScheduleMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void deleteById(int id){
		curriculumScheduleMapper.deleteByPrimaryKey(id);
	}
	public void add(CurriculumSchedule curriculumSchedule){
		curriculumScheduleMapper.insert(curriculumSchedule);
	}
	public void update(CurriculumSchedule curriculumSchedule){
		curriculumScheduleMapper.updateByPrimaryKey(curriculumSchedule);
	}
	public PageInfo<CurriculumSchedule> selectListPage(CurriculumScheduleCriteria criteria, int pageNum) {
		int totalCount = curriculumScheduleMapper.countByExample(criteria);
		PageInfo<CurriculumSchedule> page = new PageInfo<>(totalCount, -1, pageNum);
		List<CurriculumSchedule> data = curriculumScheduleMapper.selectByExampleWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
}
