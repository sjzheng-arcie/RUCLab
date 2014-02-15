package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Desk;
import edu.ruc.labmgr.domain.DeskCriteria;
import edu.ruc.labmgr.mapper.DeskMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-18
 * Time: 上午10:03
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class DeskService {
	@Autowired
	private DeskMapper deskMapper;
	public Desk getDeskById(int id){
		Desk  desk= deskMapper.selectByPrimaryKey(id);
		return desk;
	}
	public void insertDesk(Desk desk){
		deskMapper.insert(desk);
	}
	public void updateDesk(Desk desk){
		deskMapper.updateByPrimaryKey(desk);
	}
	public void deleteById(int id){
		deskMapper.deleteByPrimaryKey(id);
	}

	public PageInfo<Desk> selectListPage(DeskCriteria criteria, int pageNum) {
		int totalCount = deskMapper.countByCriteria(criteria);
		PageInfo<Desk> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Desk> data = deskMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
}
