package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-18
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(value = "/laboratory/jsp/lab/desk")
public class DeskController {
	@Autowired
	private DeskService deskService;
}
