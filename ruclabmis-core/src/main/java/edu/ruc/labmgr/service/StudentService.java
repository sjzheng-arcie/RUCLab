package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Student;
import edu.ruc.labmgr.domain.StudentCriteria;
import edu.ruc.labmgr.mapper.StudentMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public PageInfo<Student> getPageStudent(int pageNum, String sn, String name, String major) {
        StudentCriteria criteria = new StudentCriteria();
        StudentCriteria.Criteria c = criteria.or();
        if (StringUtils.isNotEmpty(sn)) {
            c.andStudentSnLike("%" + sn + "%");
        }
        if (StringUtils.isNotEmpty(name)) {
            c.andStudentNameLike("%" + name + "%");
        }
        if (StringUtils.isNotEmpty(major)) {
            c.andStudentMajorLike("%" + major + "%");
        }
        c.andJoinUser().andJoinMajor();
        return getPageStudentByCriteria(pageNum, criteria);
    }

    private PageInfo<Student> getPageStudentByCriteria(int pageNum, StudentCriteria criteria) {
        int totalCount = studentMapper.countByCriteria(criteria);
        PageInfo<Student> page = new PageInfo<>(totalCount, -1, pageNum);

        List<Student> data = studentMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }
}
