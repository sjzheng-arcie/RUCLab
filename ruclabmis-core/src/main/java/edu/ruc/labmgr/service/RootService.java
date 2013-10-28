package edu.ruc.labmgr.service;

import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-10-21
 * Time: 上午9:54
 * To change this template use File | Settings | File Templates.
 */
public class RootService {


	/*private ApplicationFormMapper applicationFormMapper ;

	public ObjectListPage<ApplicationForm> selectListPage(int currentPage, ApplicationFormCriteria criteria){


		ObjectListPage<ApplicationForm> retList = null;
		try {
			String count = SysUtil.getConfigValue("showCount", "10");

			int limit = Integer.valueOf(count);
			int currentResult = (currentPage - 1) * limit;
			int totalCount = applicationFormMapper.countByCriteria(criteria);
			int pageCount = (totalCount % limit == 0) ? (totalCount / limit) : (1 + totalCount / limit);

			PageInfo pageInfo = new PageInfo();
			pageInfo.setTotalResult(totalCount);
			pageInfo.setTotalPage(pageCount);
			pageInfo.setCurrentPage(currentPage);

			RowBounds bounds = new RowBounds(currentResult, limit);
			List<ApplicationForm> announcementList= applicationFormMapper.selectByCriteriaWithRowbounds(criteria, bounds);

			retList = new ObjectListPage(pageInfo, announcementList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retList;
	}*/
}
