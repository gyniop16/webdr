package com.amm.webdr.controller;

import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amm.webdr.model.User;

@Controller
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home")
    public String mainPage() {
        Collection<GrantedAuthority> authorities = getAuthorities();
        String rolename;
         
        for (GrantedAuthority authority : authorities) {
            rolename = authority.getAuthority();
             
            if (rolename.equals("ROLE_ADMIN")) {
                logger.debug("Directing to home page for: [" + rolename + "]");
                return "home-admin";
            }
            if (rolename.equals("ROLE_TRADER")) {
                logger.debug("Directing to home page for: [" + rolename + "]");
                return "home-trader";
            }
            if (rolename.equals("ROLE_USER")) {
                logger.debug("Directing to home page for: [" + rolename + "]");
                return "home-user";
            }
        }
         
        logger.error("Role not found - directing to home page for ROLE_USER");
        return "home-user";
    }
 
    /*@RequestMapping(value = "/home")
    public String indexPage() {
        return "redirect:/";
    }*/
     
    private Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            authorities = (Collection<GrantedAuthority>) ((User) principal).getAuthorities();
        } else {
            logger.error("Principal is not an instance of ");
        }
        return authorities;
    }
	
}
