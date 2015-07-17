package com.amm.webdr.controller.admin;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amm.webdr.model.Role;
import com.amm.webdr.service.RoleService;


@Controller
@RequestMapping("/admin/roles")
//@PreAuthorize("denyAll")
public class RoleController {
	
	protected Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private RoleService roleService;

	@ModelAttribute("list")
	public List<Role> roleList() {
 		return roleService.list();
	}	
	
	@RequestMapping(value = {"" ,"/", "/list"}, method = RequestMethod.GET)
	//@PreAuthorize("hasRole('ROLE_RIGHT_ROLES_LIST_GET')")
	public String Index(Map<String, Object> map) {
		map.put("command", new Role(true));
		//map.put("list", roleService.list());
		return "admin/roles"; 
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("command")
    @Valid Role contact, BindingResult result) {
		
		
		Role rol = roleService.getByRolename(contact.getRolename());
		if(null != rol && rol.getIdRole() != contact.getIdRole()){
			result.rejectValue("rolename","error.admin.roles.duplicated",new Object[]{contact.getRolename()}, "Role '{0}' duplicated.");
		}
		
		if (result.hasErrors()) {
            logger.info("Returning custSave.jsp page");
            return "/admin/roles";
        }
		
    	if(null != contact.getIdRole() && contact.getIdRole() > 0){
    		roleService.update(contact);
    	}else{
    		roleService.add(contact);
    	}
 
        return "redirect:/admin/roles/";
    }
	
	@RequestMapping("/delete/{idRole}")
    public String deleteContact(@PathVariable("idRole")
    Integer idRole) {
 
        roleService.remove(idRole);
 
        return "redirect:/admin/roles";
    }
    
    @RequestMapping(value="/edit/{idRole}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer idRole) {
    	ModelAndView modelAndView = new ModelAndView("/admin/roles");
    	Role role = roleService.get(idRole);
    	modelAndView.addObject("command",role);
    	//modelAndView.addObject("list", roleService.list());
    	return modelAndView;

    }
}
