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

    public PageInfo<Typecode> selectListPage(String code, String name, int Page) {
        TypecodeCriteria criteria = new TypecodeCriteria();
        criteria.setOrderByClause("id");
        TypecodeCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(code)) {
            ec.andSnLike("%" + code + "%");
        }
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        return getPageTypecodeByCritera(Page, criteria);
    }

    private PageInfo<Typecode> getPageTypecodeByCritera(int PageNum, TypecodeCriteria criteria) {
        int totalCount = typeMapper.countByCriteria(criteria);
        PageInfo<Typecode> typeCodes = new PageInfo<Typecode>(totalCount, -1, PageNum);
        List<Typecode> result = typeMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(typeCodes.getCurrentResult(), typeCodes.getPageSize()));
        typeCodes.setData(result);
        return typeCodes;

    }

    public List<Typecode> selectAllTypecode() {
        return typeMapper.selectByCriteria(null);
    }

    public int insert(Typecode title) {
        int result = 0;
        result = typeMapper.insert(title);
        return result;
    }

    public int update(Typecode title) {
        int result = 0;
        result = typeMapper.updateByPrimaryKey(title);
        return result;
    }

    public Typecode selectByPrimerKey(int id) {
        Typecode title = null;
        title = typeMapper.selectByPrimaryKey(id);
        return title;
    }

    public Integer getIdBySn(String sn) {
        TypecodeCriteria criteria = new TypecodeCriteria();
        TypecodeCriteria.Criteria ec = criteria.createCriteria();
        ec.andSnEqualTo(sn);
        List<Typecode> codes = typeMapper.selectByCriteria(criteria);
        if (codes.size() > 0)
            return codes.get(0).getId();
        else
            return null;
    }

    public int delete(int id) {
        int result = 0;
        typeMapper.deleteByPrimaryKey(id);
        return result;
    }

    public int delete(List<Integer> list) {
        int result = 0;
        if (list == null)
            return -1;
        for (Integer i : list) {
            result = typeMapper.deleteByPrimaryKey(i);
        }
        return result;

    }

}
