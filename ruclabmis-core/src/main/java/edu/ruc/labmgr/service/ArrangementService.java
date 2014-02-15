package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Arrangement;
import edu.ruc.labmgr.mapper.ArrangementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ArrangementService {

    @Autowired
    ArrangementMapper arrangementMapper;

    public int insert(Arrangement arrangement) {
        int result = 0;
        result = arrangementMapper.insert(arrangement);
        return result;
    }

    public int update(Arrangement arrangement) {
        int result = 0;
        result = arrangementMapper.updateByPrimaryKey(arrangement);
        return result;
    }

    public Arrangement selectByPrimaryKey(int id) {
        Arrangement Arrangement = null;
        Arrangement = arrangementMapper.selectByPrimaryKey(id);
        return Arrangement;
    }

    public List<Arrangement> selectAllArrangements() {
        return arrangementMapper.selectByCriteria(null);
    }

    public void delete(List<Integer> ids) {
        for(int id : ids){
            arrangementMapper.deleteByPrimaryKey(id);
        }
    }
}
