package com.amm.webdr.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amm.webdr.model.Privilege;
import com.amm.webdr.service.PrivilegeService;
import com.amm.webdr.service.RoleService;

@Controller
@RequestMapping(value = "/admin/privilege")
public class PrivilegeController {

	static Logger logger = LoggerFactory.getLogger(PrivilegeController.class);

	@Autowired
    private PrivilegeService privilegeService;
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	//@PreAuthorize("hasRole('CTRL_STRATEGY_LIST_GET')")
	public String listOfPrivileges(Model model) {
		logger.info("IN: Privilege/list-GET");

        List<Privilege> privileges = privilegeService.list();
        model.addAttribute("privileges", privileges);

        // if there was an error in /add, we do not want to overwrite
        // the existing strategy object containing the errors.
        if (!model.containsAttribute("privilege")) {
            logger.info("Adding Privilege object to model");
            Privilege privilege = new Privilege();
            model.addAttribute("privilege", privilege);
        }
        return "privilege-list";
	}
/*
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('CTRL_STRATEGY_ADD_POST')")
    public String addingStrategy(@Valid @ModelAttribute Privilege privilege,
            BindingResult result, RedirectAttributes redirectAttrs) {
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('CTRL_STRATEGY_EDIT_GET')")
    public String editStrategyPage(@RequestParam(value = "id", required = true) 
            Integer id, Model model) {
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('CTRL_STRATEGY_EDIT_POST')")
    public String editingStrategy(@Valid @ModelAttribute Privilege privilege,
            BindingResult result, RedirectAttributes redirectAttrs,
            @RequestParam(value = "action", required = true) String action) {
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('CTRL_STRATEGY_DELETE_GET')")
    public String deleteStrategyPage(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase,
            Model model) {
		
	}*/
}
