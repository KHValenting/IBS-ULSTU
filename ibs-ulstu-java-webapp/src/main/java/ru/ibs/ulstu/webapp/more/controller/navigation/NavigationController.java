package ru.ibs.ulstu.webapp.more.controller.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author KHValentin
 * Created on 14 окт. 2016 г.
 */
@Controller
public class NavigationController {

	@RequestMapping(value= "/ships")
    public String ships() {
        return "ships";
    }
	
	@RequestMapping(value= "/shipDetails")
    public String shipDetails() {
        return "shipDetails";
    }
	
}
