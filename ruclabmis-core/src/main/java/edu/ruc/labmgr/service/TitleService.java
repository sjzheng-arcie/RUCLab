package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.domain.TitleCriteria;
import edu.ruc.labmgr.mapper.TitleMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class TitleService {
    @Autowired
    private TitleMapper titleMapper;

    public PageInfo<Title> selectListPage(String name, String grade, int PageNum) {
        TitleCriteria criteria = new TitleCriteria();
        criteria.setOrderByClause("name");
        TitleCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (!StringUtils.isNullOrEmpty(grade))
            ec.andGradeLike("%" + grade + "%");
        return getTitlesByCriteria(PageNum, criteria);

    }

    private PageInfo<Title> getTitlesByCriteria(int PageNum, TitleCriteria criteria) {
        int totalCount = titleMapper.countByCriteria(criteria);
        PageInfo<Title> page = new PageInfo<>(totalCount, -1, PageNum);
        List<Title> data = titleMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(Title title) {
        int result = 0;
        result = titleMapper.insert(title);
        return result;
    }

    public int update(Title title) {
        int result = 0;
        result = titleMapper.updateByPrimaryKey(title);
        return result;
    }

    public Title selectByPrimaryKey(int id) {
        Title title = null;
        title = titleMapper.selectByPrimaryKey(id);
        return title;
    }

    public Title selectByName(String name) {
        TitleCriteria criteria = new TitleCriteria();
        TitleCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameEqualTo(name);

        List<Title> titles = titleMapper.selectByCriteria(criteria);
        if(titles.size() > 0)
            return titles.get(0);
        else
            return null;
    }

    public List<Title> selectAllTitles() {
        return titleMapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            titleMapper.deleteByPrimaryKey(id);
        }
    }

}
