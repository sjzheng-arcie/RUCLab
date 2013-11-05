package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Typecode;
import edu.ruc.labmgr.domain.TypecodeCriteria;
import edu.ruc.labmgr.mapper.TypecodeMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: sjzheng
 * Date: 13-11-4
 * Time: 下午5:35
 * Des:
 */
@SuppressWarnings("ALL")
@Service
public class TypeCodeService {
	@Autowired
	private TypecodeMapper typeMapper;

	public PageInfo<Typecode> selectListPage(String code,String name,int Page){
		TypecodeCriteria criteria = new  TypecodeCriteria();
		criteria.setOrderByClause("id");
		TypecodeCriteria.Criteria ec =  criteria.createCriteria();
		if (!StringUtils.isNullOrEmpty(code)){
			ec.andSnLike("%" + code + "%");
		}
		if (!StringUtils.isNullOrEmpty(name))
			ec.andNameLike("%" + name + "%");
		return getPageTypecodeByCritera(Page,criteria);

	}
	private  PageInfo<Typecode> getPageTypecodeByCritera(int PageNum,TypecodeCriteria criteria){
		int totalCount = typeMapper.countByCriteria(criteria);
		PageInfo<Typecode> typeCodes =  new PageInfo<Typecode>(totalCount,-1,PageNum);
		List<Typecode> result = typeMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(typeCodes.getCurrentResult(),typeCodes.getPageSize()));
		typeCodes.setData(result);
		return typeCodes;

	}

}
