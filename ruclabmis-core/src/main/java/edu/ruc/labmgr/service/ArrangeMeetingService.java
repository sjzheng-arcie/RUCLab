package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Arrangement;
import edu.ruc.labmgr.domain.ArrangementCriteria;
import edu.ruc.labmgr.mapper.ArrangementMapper;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ArrangeMeetingService {

    @Autowired
    ArrangementMapper arrangementMapper;

    public int insert(Arrangement arrangement) {
        int result = 0;
        result = arrangementMapper.insert(arrangement);
        return result;
    }

    public int update(Arrangement arrangement) {
        int result = 0;
        result = arrangementMapper.updateByPrimaryKey(arrangement);
        return result;
    }

    public Arrangement selectByPrimaryKey(int id) {
        Arrangement Arrangement = null;
        Arrangement = arrangementMapper.selectByPrimaryKey(id);
        return Arrangement;
    }

    public List<Arrangement> selectAllArrangements() {
        return arrangementMapper.selectByCriteria(null);
    }


    public  PageInfo<Arrangement> pageAllCurrArrangements(int pageNum) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue());
        arrangementCriteria.setOrderByClause("id");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }

    public  PageInfo<Arrangement> pageCurrArrangementsByUser(int pageNum, Integer userId) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue());
        arrangementCriteria.setOrderByClause("id");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }

    public  PageInfo<Arrangement> pageAllHistoryArrangements(int pageNum) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue());
        arrangementCriteria.setOrderByClause("id");
        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }

    public  PageInfo<Arrangement> pageHistoryArrangementsByUser(int pageNum, Integer userId) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue());
        arrangementCriteria.setOrderByClause("id");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }
    private PageInfo<Arrangement> getPageArrangementByCriteria(int pageNum, ArrangementCriteria criteria) {
        int totalCount = arrangementMapper.countByCriteria(criteria);
        PageInfo<Arrangement> page = new PageInfo<>(totalCount, -1, pageNum);
        List<Arrangement> data = arrangementMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public void delete(Integer id) {
        arrangementMapper.deleteByPrimaryKey(id);
    }
}
