package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.DeskCriteria;
import edu.ruc.labmgr.domain.Laboratory;
import edu.ruc.labmgr.domain.LaboratoryRoomCriteria;
import edu.ruc.labmgr.domain.LaboratoryRoomKey;
import edu.ruc.labmgr.mapper.LaboratoryRoomMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-19
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class LaboratoryRoomService {
	@Autowired
	LaboratoryRoomMapper laboratoryRoomMapper;
	@Autowired
	DeskService deskService;
	public List<LaboratoryRoomKey> getLaboratoryByCriteria(LaboratoryRoomCriteria criteria){
		List<LaboratoryRoomKey>  laboratoryRoomKeyList= laboratoryRoomMapper.selectByCriteria(criteria);
		return laboratoryRoomKeyList;
	}
	public void insertLaboratoryRoomKey(LaboratoryRoomKey laboratoryRoomKey){
		laboratoryRoomMapper.insert(laboratoryRoomKey);
	}
	public void updateLaboratoryRoomKey(LaboratoryRoomKey laboratoryRoomKey,LaboratoryRoomCriteria criteria){
		laboratoryRoomMapper.updateByCriteria(laboratoryRoomKey, criteria);
	}
	public void deleteLaboratoryRoomKey(LaboratoryRoomKey laboratoryRoomKey){
		laboratoryRoomMapper.deleteByPrimaryKey(laboratoryRoomKey);
	}
	public void delete(LaboratoryRoomKey laboratoryRoomKey){
		laboratoryRoomMapper.deleteByPrimaryKey(laboratoryRoomKey);
	}
	public List<Integer> getAllRoomIdByLaboratoryId(int laboratoryId){
		LaboratoryRoomCriteria laboratoryRoomCriteria = new LaboratoryRoomCriteria();
		LaboratoryRoomCriteria.Criteria criteria =laboratoryRoomCriteria.createCriteria();
		criteria.andLaboratoryIdEqualTo(laboratoryId);
		List<LaboratoryRoomKey> laboratoryRoomKeyList = laboratoryRoomMapper.selectByCriteria(laboratoryRoomCriteria);
		List<Integer> allRoomIdList=new <Integer>ArrayList();
		for(int i=0;i<laboratoryRoomKeyList.size();i++){
			allRoomIdList.add(laboratoryRoomKeyList.get(i).getLaboratoryRoomId());
		}
		return  allRoomIdList;
	}
	public void deleteByCriteria(LaboratoryRoomCriteria criteria){
		List<LaboratoryRoomKey> list=laboratoryRoomMapper.selectByCriteria(criteria);
		for(LaboratoryRoomKey laboratoryRoomKey:list){
			DeskCriteria deskCriteria = new DeskCriteria();
			DeskCriteria.Criteria criteria1= deskCriteria.createCriteria();
			criteria1.andLaboratoryRoomIdEqualTo(laboratoryRoomKey.getLaboratoryRoomId());
			deskService.deleteByCriteria(deskCriteria);
		}
		laboratoryRoomMapper.deleteByCriteria(criteria);
	}
	public PageInfo<LaboratoryRoomKey> selectListPage(LaboratoryRoomCriteria criteria, int pageNum) {
		int totalCount = laboratoryRoomMapper.countByCriteria(criteria);
		PageInfo<LaboratoryRoomKey> page = new PageInfo<>(totalCount, -1, pageNum);
		List<LaboratoryRoomKey> data = laboratoryRoomMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
	public List<LaboratoryRoomKey> getAllLaboratoryList(){
		return laboratoryRoomMapper.selectByCriteria(null);
	}

}
