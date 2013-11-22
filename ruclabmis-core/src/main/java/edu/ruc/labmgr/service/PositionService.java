package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Position;
import edu.ruc.labmgr.domain.PositionCriteria;
import edu.ruc.labmgr.mapper.PositionMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public PageInfo<Position> selectListPage(String name, String grade, int PageNum) {
        PositionCriteria criteria = new PositionCriteria();
        criteria.setOrderByClause("name");
        PositionCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (!StringUtils.isNullOrEmpty(grade))
            ec.andGradeLike("%" + grade + "%");
        return getPositionsByCriteria(PageNum, criteria);

    }

    private PageInfo<Position> getPositionsByCriteria(int PageNum, PositionCriteria criteria) {
        int totalCount = positionMapper.countByCriteria(criteria);
        PageInfo<Position> page = new PageInfo<>(totalCount, -1, PageNum);
        List<Position> data = positionMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(Position position) {
        int result = 0;
        result = positionMapper.insert(position);
        return result;
    }

    public int update(Position position) {
        int result = 0;
        result = positionMapper.updateByPrimaryKey(position);
        return result;
    }

    public Position selectByPrimerKey(int id) {
        Position position = null;
        position = positionMapper.selectByPrimaryKey(id);
        return position;
    }

    public List<Position> selectAllPositions() {
        return positionMapper.selectByCriteria(null);
    }

    public int delete(int id) {
        int result = 0;
        positionMapper.deleteByPrimaryKey(id);
        return result;
    }

}
