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


@SuppressWarnings("ALL")
@Service
public class TermYearService {

    @Autowired
    private TermYearMapper mapper;

    public List<TermYear> getAllTermYearList(){
        TermYearCriteria yearCriteria= new TermYearCriteria();
        yearCriteria.setOrderByClause("name");
        return mapper.selectByCriteria(yearCriteria);
    }

    public List<TermYear> getCurrentTermYear(){
        TermYearCriteria yearCriteria= new TermYearCriteria();
        yearCriteria.setOrderByClause("name");
        return mapper.selectByCriteria(yearCriteria);
    }

    public TermYear getTermYearById(Integer id){
        return mapper.selectByPrimaryKey(id);
    }


    public List<Integer> getIdByYear(Integer year){
        TermYearCriteria yearCriteria = new TermYearCriteria();
        TermYearCriteria.Criteria ec = yearCriteria.createCriteria();
        ec.andYearEqualTo(year);
        List<TermYear> years = mapper.selectByCriteria(yearCriteria);
        List<Integer> retVals = new ArrayList<Integer>();
        for(TermYear termYear : years)
        {
            retVals.add(termYear.getId());
        }
        return retVals;
    }
}
