package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.domain.TitleCriteria;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.TitleMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sjzheng
 * Date: 13-10-28
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class TitleService {
	@Autowired
	private TitleMapper titleMapper;

	public PageInfo<Title> selectListPage(String name, String  grade,int PageNum){
		TitleCriteria criteria = new TitleCriteria();
		criteria.setOrderByClause("name");
		TitleCriteria.Criteria ec = criteria.createCriteria();
		if (StringUtils.isNotEmpty(name))
			ec.andNameLike("%" + name + "%");
		if (StringUtils.isNotEmpty(grade))
			ec.andGradeLike("%" + grade + "%");
		return getTitlesByCriteria(PageNum,criteria);

	}
	private PageInfo<Title> getTitlesByCriteria(int PageNum,TitleCriteria criteria){
		int totalCount = titleMapper.countByCriteria(criteria);
		PageInfo<Title> page = new PageInfo<>(totalCount,-1,PageNum);
		List<Title> data = titleMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(),page.getPageSize()));
		page.setData(data);
		return page;
	}

	public int insert(Title title){
		int result = 0;
		result=titleMapper.insert(title);
		return result;
	}
	public int update(Title title){
		int result = 0;
		result = titleMapper.updateByPrimaryKey(title);
		return result;
	}
	public Title selectByPrimerKey(int id){
		Title title = null;
		title = titleMapper.selectByPrimaryKey(id);
		return title;
	}
	public int delete(int  id){
		int result = 0;
		titleMapper.deleteByPrimaryKey(id);
		return result;
	}

}
