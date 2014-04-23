package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Task;
import edu.ruc.labmgr.domain.TaskCriteria;
import edu.ruc.labmgr.mapper.TaskMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-20
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class TaskService {
	@Autowired
	TaskMapper taskMapper;

	public void insert(Task task){
		taskMapper.insert(task);
	}

	public Task getTaskById(int taskId){
		return taskMapper.selectByPrimaryKey(taskId);
	}
	public void updateByPrimaryKey(Task task){
		taskMapper.updateByPrimaryKeySelective(task);
	}

	public void deleteById(int id){
		taskMapper.deleteByPrimaryKey(id);
	}

	public List<Task> getTaskList(){
		List<Task> taskList = taskMapper.selectByExample(null);
		return taskList;
	}
	public PageInfo<Task> selectListPage(TaskCriteria criteria, int pageNum) {
		int totalCount = taskMapper.countByExample(criteria);
		PageInfo<Task> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Task> data = taskMapper.selectByExampleWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}

}
