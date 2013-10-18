package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class MajorService {
    @Autowired
    private MajorMapper mapperMajor;

    public Major selectByPrimaryKey(int id) {
        Major role = null;
        try {
            role = (Major) mapperMajor.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public List<Major> listAll() {
        return mapperMajor.selectByCriteria(null);
    }
}
