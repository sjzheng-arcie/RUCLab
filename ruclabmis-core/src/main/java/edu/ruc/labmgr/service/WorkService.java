package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Work;
import edu.ruc.labmgr.domain.WorkCriteria;
import edu.ruc.labmgr.mapper.WorkMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-27
 * Time: 上午9:05
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class WorkService {
	@Autowired
	WorkMapper workMapper;

	public void insert(Work work){
		workMapper.insert(work);
	}

	public void deleteById(int id){
		workMapper.deleteByPrimaryKey(id);
	}
	public void update(Work work){
		workMapper.updateByPrimaryKey(work);
	}

	public Work getWorkById(int id){
		return workMapper.selectByPrimaryKey(id);
	}
	public PageInfo<Work> selectListPage(WorkCriteria criteria, int pageNum) {
		int totalCount = workMapper.countByCriteria(criteria);
		PageInfo<Work> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Work> data = workMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
}
