package edu.ruc.labmgr.service;
import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.domain.TermYearCriteria;
import edu.ruc.labmgr.mapper.TermYearMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: sjzheng
 * Date: 13-12-26
 * Time: 下午2:38
 * Des:
 */
@SuppressWarnings("ALL")
@Service
public class SchoolCalenderService {
	@Autowired
	TermYearMapper termYearMapper;
	public PageInfo<TermYear> getPageListbyNum(int pageNum){
		TermYearCriteria criteria = new TermYearCriteria();
		TermYearCriteria.Criteria c = criteria.or();
		return  getPageListbyCriteria(pageNum, criteria);

	}
	public List<TermYear> getAllTermYear(){
		return termYearMapper.selectByCriteria(null);
	}
	public TermYear getTermYearByPk(int id){
		TermYear termYear = null;
		termYear = termYearMapper.selectByPrimaryKey(id);
		return  termYear;
	}
	public int updateTermYear(TermYear termYear){
		int result = 0;
		result =termYearMapper.updateByPrimaryKey(termYear);
		return  result;
	}
	public int addTerYear(TermYear termYear){
		int result = 0;
		result = termYearMapper.insert(termYear);
		return  result;
	}
	public int deleteTermYear(int id){
		int result = 0;
		result = termYearMapper.deleteByPrimaryKey(id);
		return result;
	}
	private PageInfo<TermYear> getPageListbyCriteria(int page ,TermYearCriteria criteria){
		int totalCount = termYearMapper.countByCriteria(criteria);
		PageInfo<TermYear> pageInfo = new PageInfo<>(totalCount,-1,page);
		List<TermYear> termYearList = new ArrayList<>();
		termYearList = termYearMapper.selectByCriteriaWithRowbounds(criteria,new RowBounds(pageInfo.getCurrentResult(),
				pageInfo.getPageSize()));
		pageInfo.setData(termYearList);
		return pageInfo;
	}
}
