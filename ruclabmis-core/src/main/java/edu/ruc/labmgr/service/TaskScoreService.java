package edu.ruc.labmgr.service;



import edu.ruc.labmgr.domain.Taskscore;
import edu.ruc.labmgr.domain.TaskscoreCriteria;
import edu.ruc.labmgr.mapper.TaskscoreMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-23
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class TaskScoreService {
	@Autowired
	TaskscoreMapper taskscoreMapper;

	public void add(Taskscore taskscore){
		taskscoreMapper.insert(taskscore);
	}

	public void update(Taskscore taskscore){
		taskscoreMapper.updateByPrimaryKey(taskscore);
	}

	public void deleteById(int id){
		taskscoreMapper.deleteByPrimaryKey(id);
	}
	public void deleteByCriteria(TaskscoreCriteria criteria){
		taskscoreMapper.deleteByCriteria(criteria);

	}
	public PageInfo<Taskscore> selectListPage(TaskscoreCriteria criteria, int pageNum) {
		int totalCount = taskscoreMapper.countByCriteria(criteria);
		PageInfo<Taskscore> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Taskscore> data = taskscoreMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
	public Taskscore getTasckScoreById(int id){
		Taskscore taskscore = taskscoreMapper.selectByPrimaryKey(id);
		return taskscore;
	}


	public List<Taskscore> getListByMarkerId(int id){
		TaskscoreCriteria taskscoreCriteria= new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria = taskscoreCriteria.createCriteria();
		criteria.andMarkeridEqualTo(id);
		List<Taskscore> taskscoreList= taskscoreMapper.selectByCriteria(taskscoreCriteria);
		return  taskscoreList;
	}
	public List<Integer> getTaskIdListByMarkerId(int id){
		TaskscoreCriteria taskscoreCriteria= new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria = taskscoreCriteria.createCriteria();
		criteria.andMarkeridEqualTo(id);
		List<Taskscore> taskscoreList= taskscoreMapper.selectByCriteria(taskscoreCriteria);
		List<Integer> taskIdList=new ArrayList<>();
		for(Taskscore taskscore:taskscoreList){
			taskIdList.add(taskscore.getTaskid());
		}
		return  taskIdList;
	}
	public Taskscore getListByMarkerAndTask(int taskId,int markerId){
		TaskscoreCriteria taskscoreCriteria= new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria = taskscoreCriteria.createCriteria();
		criteria.andMarkeridEqualTo(markerId);
		criteria.andTaskidEqualTo(taskId);
		if(taskscoreMapper.selectByCriteria(taskscoreCriteria)!=null&&taskscoreMapper.selectByCriteria(taskscoreCriteria).size()>0){
			return taskscoreMapper.selectByCriteria(taskscoreCriteria).get(0);
		}
		return new Taskscore();
	}


}
