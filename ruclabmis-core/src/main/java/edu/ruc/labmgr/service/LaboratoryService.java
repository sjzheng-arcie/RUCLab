package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Laboratory;
import edu.ruc.labmgr.domain.LaboratoryCriteria;
import edu.ruc.labmgr.mapper.LaboratoryMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-18
 * Time: 下午2:26
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class LaboratoryService {
	@Autowired
	LaboratoryMapper laboratoryMapper;
	public Laboratory getLaboratoryById(int id){
		Laboratory  laboratory= laboratoryMapper.selectByPrimaryKey(id);
		return laboratory;
	}
	public void insertLaboratory(Laboratory laboratory){
		laboratoryMapper.insert(laboratory);
	}
	public void updateLaboratory(Laboratory laboratory){
		laboratoryMapper.updateByPrimaryKey(laboratory);
	}
	public void deleteById(int id){
		laboratoryMapper.deleteByPrimaryKey(id);
	}

	public PageInfo<Laboratory> selectListPage(LaboratoryCriteria criteria, int pageNum) {
		int totalCount = laboratoryMapper.countByCriteria(criteria);
		PageInfo<Laboratory> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Laboratory> data = laboratoryMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
	public List<Laboratory> getAllLaboratory(){
		List<Laboratory> laboratoryList=laboratoryMapper.selectByCriteria(null);
		return laboratoryList;
	}
}
