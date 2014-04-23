package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.TaskType;
import edu.ruc.labmgr.domain.TaskTypeCriteria;
import edu.ruc.labmgr.mapper.TaskTypeMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 14-4-22
 * Time: 上午9:38
 * To change this template use File | Settings | File Templates.
 */

@Service
@SuppressWarnings("ALL")
public class TaskTypeService {
	@Autowired
	TaskTypeMapper taskTypeMapper;

	public void insert(TaskType taskType){
		taskTypeMapper.insert(taskType);

	};

	public void  delete(int id){
		taskTypeMapper.deleteByPrimaryKey(id);
	}

	public void update(TaskType taskType){
		taskTypeMapper.updateByPrimaryKeySelective(taskType);
	}
	public TaskType getTaskTypeByIf(int  id ){
		return  taskTypeMapper.selectByPrimaryKey(id);
	}

	public PageInfo<TaskType> selectListPage(String typeName, int pageNum) {
		TaskTypeCriteria taskTypeCriteria = new TaskTypeCriteria();
		taskTypeCriteria.createCriteria().andTypeNameLike("%"+typeName+"%");
		int totalCount = taskTypeMapper.countByExample(taskTypeCriteria);

		PageInfo<TaskType> page = new PageInfo<>(totalCount, -1, pageNum);
		List<TaskType> data = taskTypeMapper.selectByExampleWithRowbounds(taskTypeCriteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
	public List<TaskType> getTaskTypeList(){
		return  taskTypeMapper.selectByExample(null);
	}

}
