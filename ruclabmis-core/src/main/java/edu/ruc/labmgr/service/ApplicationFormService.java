package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplicationFormCriteria;
import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.ClassifCriteria;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.ClassifMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("ALL")
@Service
public class ApplicationFormService {

    @Autowired
    private ApplicationFormMapper applicationFormMapper;


	public List<ApplicationForm> selectListByState(ApplicationFormCriteria applicationFormCriteria) {
		List<ApplicationForm> applicationFormList = null;

		try{
			RowBounds bounds = new RowBounds(0, 6);
			applicationFormList= applicationFormMapper.selectByCriteriaWithRowbounds(applicationFormCriteria,bounds);
		}catch (Exception e){
			e.printStackTrace();
		}
			return applicationFormList;
	}

	public PageInfo<ApplicationForm> selectListPage(ApplicationFormCriteria criteria, int pageNum){
		int totalCount = applicationFormMapper.countByCriteria(criteria);
		PageInfo<ApplicationForm> page = new PageInfo<>(totalCount,-1,pageNum);
		List<ApplicationForm> data = applicationFormMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(),page.getPageSize()));
		page.setData(data);
		return page;
	}



}
