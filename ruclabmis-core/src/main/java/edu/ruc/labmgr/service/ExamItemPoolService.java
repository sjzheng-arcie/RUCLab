package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ExamItemPool;
import edu.ruc.labmgr.domain.ExamItemPoolCriteria;
import edu.ruc.labmgr.mapper.ExamItemPoolMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ExamItemPoolService {
    @Autowired
    private ExamItemPoolMapper mapper;

    public PageInfo<ExamItemPool> selectListPage(String name, int PageNum) {
        ExamItemPoolCriteria criteria = new ExamItemPoolCriteria();
        criteria.setOrderByClause("name");
        ExamItemPoolCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");

        return getExamItemPoolsByCriteria(PageNum, criteria);
    }

    private PageInfo<ExamItemPool> getExamItemPoolsByCriteria(int PageNum, ExamItemPoolCriteria criteria) {
        int totalCount = mapper.countByCriteria(criteria);
        PageInfo<ExamItemPool> page = new PageInfo<>(totalCount, -1, PageNum);
        List<ExamItemPool> data = mapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public int insert(ExamItemPool examItemPool) {
        int result = 0;
        result = mapper.insert(examItemPool);
        return result;
    }

    public int update(ExamItemPool examItemPool) {
        int result = 0;
        result = mapper.updateByPrimaryKey(examItemPool);
        return result;
    }

    public ExamItemPool selectByPrimaryKey(int id) {
        ExamItemPool ExamItemPool = null;
        ExamItemPool = mapper.selectByPrimaryKey(id);
        return ExamItemPool;
    }

    public List<ExamItemPool> selectAllExamItemPools() {
        return mapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            mapper.deleteByPrimaryKey(id);
        }
    }

    public void generateDocument(String filePath, List<Integer> listSubjectId) throws IOException {
		String CHARSET = "gbk";//编码格式

		if(listSubjectId.size() <= 0)
            return;

        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String content = "";
		String header = "<html xmlns:v=\"urn:schemas-microsoft-com:vml\" \n" +
				"xmlns:o=\"urn:schemas-microsoft-com:office:office\" \n" +
				"xmlns:w=\"urn:schemas-microsoft-com:office:word\" \n" +
				"xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\" \n" +
				"xmlns=\"http://www.w3.org/TR/REC-html40\">";
		content+=header;
        for(int id : listSubjectId)
        {
            ExamItemPool subject = selectByPrimaryKey(id);
            content += subject.getSubstance();
            content += "\r\n";
        }
		String end = "</html>";
		content+=end;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),CHARSET));
        bw.write(content);
        bw.newLine();
        bw.close();
    }

}
