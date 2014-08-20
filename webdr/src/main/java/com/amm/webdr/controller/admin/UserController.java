package com.amm.webdr.controller.admin;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amm.webdr.model.Role;
import com.amm.webdr.model.User;
import com.amm.webdr.service.RoleService;
import com.amm.webdr.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController {
	
	protected Log logger = LogFactory.getLog(getClass());

	@Autowired 
	private UserService userService;
	
	@Autowired 
	private RoleService roleService;
	
	@ModelAttribute("list")
	public List<User> userList() {
 		return userService.list();
	}	
	
	@ModelAttribute("roleList")
	public List<Role> roleList() {
 		return roleService.list(true);
	}	
	
	@InitBinder
    private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, "roles", new CustomCollectionEditor(Set.class) {
			@Override
		    protected Object convertElement(Object userId)  {
				Role role = new Role();
				Integer idRole = Integer.parseInt((String) userId);
				role.setIdRole(idRole);
		        return role;
		    }
		});
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String Index(ModelMap map) { 
		map.put("command", new User(true));
		return "admin/users";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("command")
    @Valid User model, BindingResult result) {
		User user = userService.getByUserename(model.getUsername());
		if(null != user && user.getIdUser() != model.getIdUser()){
			result.rejectValue("username","error.admin.user.duplicated",new Object[]{model.getUsername()}, "User '{0}' duplicated.");
		}
		
		if (result.hasErrors()) {
            logger.info("Returning custSave.jsp page");
            return "/admin/users";
        }
		
    	if(null != model.getIdUser() && model.getIdUser() > 0){
    		userService.update(model);
    	}else{
    		userService.add(model);
    	} 
        return "redirect:/admin/users";
    }
	
	@RequestMapping("/delete/{idUser}")
    public String deleteContact(@PathVariable("idUser")
    Integer idUser) { 
        userService.remove(idUser);
        return "redirect:/admin/users";
    }
    
    @RequestMapping(value="/edit/{idUser}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer idUser) {
    	ModelAndView modelAndView = new ModelAndView("/admin/users");
    	User user = userService.get(idUser);
    	modelAndView.addObject("command",user);
    	return modelAndView;

    }
	
}
