package com.amm.webdr.controller.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amm.webdr.model.Privilege;
import com.amm.webdr.model.Role;
import com.amm.webdr.model.User;
import com.amm.webdr.service.PrivilegeService;
import com.amm.webdr.service.RoleService;

@Controller
@RequestMapping(value = "/admin/rolesprivileges")
public class RolePrivilegeController {

protected Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private RoleService roleService;

	@Autowired
    private PrivilegeService privilegeService;
	
	@ModelAttribute("roles")
	public List<Role> roleList() {
 		return roleService.list(true);
	}	
	
	@ModelAttribute("privileges")
	public List<Privilege> privilegeList() {
 		return privilegeService.list(true);
	}	
	
		
	@RequestMapping(value = {"" ,"/"}, method = RequestMethod.GET)
//	@PreAuthorize("hasPrivilege('CTRL_" + SECTION + "_LIST_GET')")
	public String listOfPrivilegesPerRole(Map<String, Object> map) {
		logger.info("IN: RolePrivilege/list-GET");
        return "admin/roleprivilege";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam(value="roleprivilege", required=false)
     String[] roleprivileges) {
		
		Map<Integer,Role> rolesMap = new HashMap<Integer, Role>();
		if(roleprivileges != null){
			for(String roleprivilege : roleprivileges){
				if(null != roleprivilege && !"".equals(roleprivilege)){
					String[] rolePriv = roleprivilege.split("_"); 
					if(rolePriv != null && rolePriv.length == 2){
						String idRoleStr, idPrivilegeStr;
						idRoleStr = rolePriv[0];
						idPrivilegeStr = rolePriv[1];

						Integer idRole, idPrivilege;
						idRole = Integer.parseInt(idRoleStr);
						idPrivilege = Integer.parseInt(idPrivilegeStr);
						Role role;
						if(rolesMap.containsKey(idRole)){
							role = rolesMap.get(idRole);
						}else{
							role = roleService.get(idRole);
							role.setPrivileges(null);
							rolesMap.put(idRole, role);
						}
						Privilege privilege = new Privilege();
						privilege.setIdPrivilege(idPrivilege);
						role.getPrivileges().add(privilege);
					}
				}
			}
		}
    	 
		roleService.savePrivilegesPerRole(new ArrayList<Role>(rolesMap.values()));
		
        return "redirect:/admin/rolesprivileges/";
    }
	
}
