package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.domain.TermYearCriteria;
import edu.ruc.labmgr.mapper.TermYearMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
