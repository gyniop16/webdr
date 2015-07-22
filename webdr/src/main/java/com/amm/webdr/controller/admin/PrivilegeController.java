package com.amm.webdr.controller.admin;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amm.webdr.model.Privilege;
import com.amm.webdr.service.PrivilegeService;

@Controller
@RequestMapping(value = "/admin/privileges")
public class PrivilegeController {

	static Logger logger = LoggerFactory.getLogger(PrivilegeController.class);

//	static final String SECTION = "PRIVILEGE";
	
	@Autowired
    private PrivilegeService privilegeService;
	
	@ModelAttribute("list")
	public List<Privilege> list() {
 		return privilegeService.list();
	}
	
	@RequestMapping(value = {"" ,"/", "/list"}, method = RequestMethod.GET)
//	@PreAuthorize("hasPrivilege('CTRL_" + SECTION + "_LIST_GET')")
	public String listOfPrivileges(Map<String, Object> map) {
		logger.info("IN: Privilege/list-GET");

		map.put("command", new Privilege(true));
        return "admin/privileges";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("command")
    @Valid Privilege contact, BindingResult result) {
		
		
		Privilege privilege = privilegeService.getByPrivilegename(contact.getPrivilegename());
		if(null != privilege && privilege.getIdPrivilege() != contact.getIdPrivilege()){
			result.rejectValue("privilegename","error.admin.privilege.duplicated",new Object[]{contact.getPrivilegename()}, "Privilege '{0}' duplicated.");
		}
		
		if (result.hasErrors()) {
            logger.info("Returning /admin/Privileges.jsp page");
            return "/admin/privileges";
        }
		
    	if(null != contact.getIdPrivilege() && contact.getIdPrivilege() > 0){
    		privilegeService.update(contact);
    	}else{
    		privilegeService.add(contact);
    	}
 
        return "redirect:/admin/privileges/";
    }
	
	@RequestMapping("/delete/{idPrivilege}")
    public String deleteContact(@PathVariable("idPrivilege")
    Integer idPrivilege) {
 
        privilegeService.remove(idPrivilege);
 
        return "redirect:/admin/privileges";
    }
    
    @RequestMapping(value="/edit/{idPrivilege}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer idPrivilege) {
    	ModelAndView modelAndView = new ModelAndView("/admin/privileges");
    	Privilege privilege = privilegeService.get(idPrivilege);
    	modelAndView.addObject("command",privilege);
    	//modelAndView.addObject("list", PrivilegeService.list());
    	return modelAndView;

    }
}
