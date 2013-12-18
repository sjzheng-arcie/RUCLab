package edu.ruc.labmgr.service;

import edu.ruc.labmgr.mapper.DeskMapper;
import edu.ruc.labmgr.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-18
 * Time: 上午10:03
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class DeskService {
	@Autowired
	private DeskMapper deskMapper;
}
