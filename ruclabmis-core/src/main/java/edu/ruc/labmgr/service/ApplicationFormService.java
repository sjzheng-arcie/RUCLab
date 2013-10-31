package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplicationFormCriteria;
import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.ClassifCriteria;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.ClassifMapper;
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
			RowBounds bounds = new RowBounds(1, 8);
			applicationFormList= applicationFormMapper.selectByCriteriaWithRowbounds(applicationFormCriteria,bounds);
		}catch (Exception e){
			e.printStackTrace();
		}
			return applicationFormList;
	}
}
