package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.TaskCharger;
import edu.ruc.labmgr.domain.TaskChargerCriteria;
import edu.ruc.labmgr.mapper.TaskChargerMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 14-4-18
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
@Service
@SuppressWarnings("ALL")
public class TaskChargerService {
	@Autowired
	TaskChargerMapper taskChargerMapper;


	public void insert(TaskCharger taskCharger){
		taskChargerMapper.insert(taskCharger);
	}

	public void update(TaskCharger taskCharger){
		taskChargerMapper.updateByPrimaryKeySelective(taskCharger);
	}

	public void deleteById(int id){
		taskChargerMapper.deleteByPrimaryKey(id);
	}

	public void deleteByTaskId(int taskId){
		TaskChargerCriteria taskChargerCriteria= new TaskChargerCriteria();
		taskChargerCriteria.createCriteria().andTaskidEqualTo(taskId);
		taskChargerMapper.deleteByExample(taskChargerCriteria);
	}

	public List<TaskCharger> getTaskChargerByTaskId(int id){
		TaskChargerCriteria taskChargerCriteria= new TaskChargerCriteria();
		taskChargerCriteria.createCriteria().andTaskidEqualTo(id);
		return taskChargerMapper.selectByExample(taskChargerCriteria);

	}
	public List<Integer> getTaskIdListByChagerId(int id){
		TaskChargerCriteria taskChargerCriteria= new TaskChargerCriteria();
		taskChargerCriteria.createCriteria().andChargeridEqualTo(id);
		List<Integer> taskIdList=new ArrayList();
		for(TaskCharger taskCharger:taskChargerMapper.selectByExample(taskChargerCriteria)){
			taskIdList.add(taskCharger.getTaskid());
		}
		return taskIdList;

	}
	public PageInfo<TaskCharger> selectListPage(String taskName,int chargerId,int type,int ifCompleted,int ifScored, int pageNum) {
		int totalCount = taskChargerMapper.countTaskChargerList(taskName, chargerId, type, ifCompleted, ifScored);
		PageInfo<TaskCharger> page = new PageInfo<>(totalCount, -1, pageNum);
		List<TaskCharger> data = taskChargerMapper.selectTaskChargerList(taskName, chargerId, type, ifCompleted, ifScored,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}


}
