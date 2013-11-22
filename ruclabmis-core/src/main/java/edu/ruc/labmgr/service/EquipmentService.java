package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCriteria;
import edu.ruc.labmgr.domain.Teacher;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private TeacherService serviceTeacher;
    @Autowired
    private TypeCodeService serviceTypecode;
    @Autowired
    private ClassifService serviceClassif;

    private PageInfo<Equipment> getPageEquipmentByCriteria(int pageNum, EquipmentCriteria criteria) {
        int totalCount = equipmentMapper.countByCriteria(criteria);
        PageInfo<Equipment> page = new PageInfo<>(totalCount, -1, pageNum);
        List<Equipment> data = equipmentMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));

        page.setData(data);
        return page;
    }

    //设备统计
    public PageInfo<Equipment> queryPageEquipments(Equipment equipment, int pageNum) {
        if (equipment == null)
            return getPageEquipmentByCriteria(pageNum, null);

        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();

        if (!StringUtils.isNullOrEmpty(equipment.getSn()))
            ec.andSnLike("%" + equipment.getSn() + "%");
        if (!StringUtils.isNullOrEmpty(equipment.getName()))
            ec.andNameLike("%" + equipment.getName() + "%");
        if (!StringUtils.isNullOrEmpty(equipment.getHolderName())) {

            List<Teacher> holders = serviceTeacher.getTeacherListNameLike(equipment.getHolderName());
            List<Integer> holderIds = new ArrayList<Integer>();
            for (Teacher holder : holders) {
                holderIds.add(holder.getId());
            }
            ec.andHolderIn(holderIds);
        }

        if (equipment.getCategoryId() != null && equipment.getCategoryId() >= 0)
            ec.andCategoryIdEqualTo(equipment.getCategoryId());
        //部门

        if (!StringUtils.isNullOrEmpty(equipment.getModelNumber()))
            ec.andModelNumberLike("%" + equipment.getModelNumber() + "%");
        if (!StringUtils.isNullOrEmpty(equipment.getSpecifications()))
            ec.andSpecificationsLike("%" + equipment.getSpecifications() + "%");
        if (equipment.getUnitPrice() != null)
            ec.andUnitPriceEqualTo(equipment.getUnitPrice());
        if (equipment.getUnitPrice() != null)
            ec.andUnitPriceEqualTo(equipment.getUnitPrice());
        if (!StringUtils.isNullOrEmpty(equipment.getVender()))
            ec.andVenderLike("%" + equipment.getVender() + "%");
        if (!StringUtils.isNullOrEmpty(equipment.getFactoryNumber()))
            ec.andFactoryNumberLike("%" + equipment.getFactoryNumber() + "%");
        if (!StringUtils.isNullOrEmpty(equipment.getCountry()))
            ec.andCountryLike("%" + equipment.getCountry() + "%");
        if (equipment.getStateId() != null && equipment.getStateId() >= 0)
            ec.andStateIdEqualTo(equipment.getStateId());
        if (equipment.getFundingSubjectId() != null && equipment.getFundingSubjectId() >= 0)
            ec.andFundingSubjectIdEqualTo(equipment.getFundingSubjectId());
        if (equipment.getUseDirectionId() != null && equipment.getUseDirectionId() >= 0)
            ec.andUseDirectionIdEqualTo(equipment.getUseDirectionId());

        return getPageEquipmentByCriteria(pageNum, criteria);
    }

    //分页过滤可用设备
    public PageInfo<Equipment> getPageAvaiableEquipments(String sn, String name, int useDirect, int pageNum) {
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (useDirect > 0) {
            ec.andUseDirectionIdEqualTo(useDirect);
        }
        ec.andStateIdEqualTo(Types.EquipState.NORMAL.getValue());
        return getPageEquipmentByCriteria(pageNum, criteria);
    }

    //分页过滤用户名下的可用设备
    public PageInfo<Equipment> getUserPageBorrowedEquipments(String sn, String name, int useDirect, int userId, int pageNum) {
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (useDirect > 0)
            ec.andUseDirectionIdEqualTo(useDirect);
        if (userId >= 0)
            ec.andHolderEqualTo(userId);
        ec.andStateIdEqualTo(Types.EquipState.USED.getValue());

        return getPageEquipmentByCriteria(pageNum, criteria);
    }

    //分页过滤可报减设备，可用或已损坏
    public PageInfo<Equipment> getPageToRepairEquipments(String sn, String name, int useDirect, int pageNum) {
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (useDirect > 0)
            ec.andUseDirectionIdEqualTo(useDirect);

        List<Integer> state = new ArrayList<Integer>();
        state.add(Types.EquipState.NORMAL.getValue());
        state.add(Types.EquipState.BROKEN.getValue());
        ec.andStateIdIn(state);

        return getPageEquipmentByCriteria(pageNum, criteria);
    }

    //分页过滤所有数据
    public PageInfo<Equipment> getPageEquipments(String sn, String name, int useDirect, int pageNum) {
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (useDirect > 0) {
            ec.andUseDirectionIdEqualTo(useDirect);
        }
        return getPageEquipmentByCriteria(pageNum, criteria);
    }

    public void returnEquipments(List<Integer> equipmentIds) {
        for (int id : equipmentIds) {
            Equipment equipment = equipmentMapper.selectByPrimaryKey(id);
            equipment.setId(id);
            equipment.setHolder(null);
            equipment.setUser(null);
            equipment.setStateId(Types.EquipState.NORMAL.getValue());
            equipmentMapper.updateByPrimaryKey(equipment);
        }
    }

    public Equipment selectByPrimaryKey(int id) {
        return equipmentMapper.selectByPrimaryKey(id);
    }

    public void insertEquipment(Equipment equipment) {
        equipmentMapper.insert(equipment);
    }

    public void updateEquipment(Equipment equipment) throws Exception {
        if (!StringUtils.isNullOrEmpty(equipment.getHolderName())) {
            int id = serviceTeacher.getUserIdByName(equipment.getHolderName());
            if (id < 0) {
                throw (new Exception("领用人不存在，请检查后重新输入"));
            }
            equipment.setHolder(id);
        } else {
            equipment.setHolder(null);
        }
        equipmentMapper.updateByPrimaryKey(equipment);
    }

    public void saveOrUpdateEquipments(List<Equipment> equipments) {
        if (equipments != null) {
            for (Equipment equipment : equipments) {
                String sn = equipment.getSn();
                if (StringUtils.isNullOrEmpty(sn))
                    continue;

                if (!StringUtils.isNullOrEmpty(equipment.getCategorySn())) {
                    Integer categoryId = serviceTypecode.getIdBySn(equipment.getCategorySn());
                    equipment.setCategoryId(categoryId);
                }

                if (!StringUtils.isNullOrEmpty(equipment.getFundingSubject())) {
                    Integer fundingSubjectId = serviceClassif.getIdByName(equipment.getFundingSubject());
                    equipment.setFundingSubjectId(fundingSubjectId);
                }
                if (!StringUtils.isNullOrEmpty(equipment.getUseDirection())) {
                    Integer useDirectionId = serviceClassif.getIdByName(equipment.getUseDirection());
                    equipment.setUseDirectionId(useDirectionId);
                }
                equipment.setStateId(Types.EquipState.NORMAL.getValue());

                Integer id = equipmentMapper.selectIdBySn(sn);
                if (id != null && id > 0) {
                    equipment.setId(id);
                    equipmentMapper.updateByPrimaryKey(equipment);
                } else {
                    equipmentMapper.insert(equipment);
                }
            }
        }
    }


    public void deleteEquipments(List<Integer> equipmentIds) {
        for (int id : equipmentIds)
            equipmentMapper.deleteByPrimaryKey(id);
    }
}
