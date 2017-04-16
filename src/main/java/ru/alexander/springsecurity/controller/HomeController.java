package ru.alexander.springsecurity.controller;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.alexander.springsecurity.service.ProccessService;

@Controller
public class HomeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private AccessDecisionManager accessDecisionManager;
    
    @Autowired
    private ProccessService proccessService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage() {
//        Вызо защищённого метода
//        this.proccessService.getMessage();
        printUserDetails();
        return "/content/user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "/content/admin";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Ошибка аунтификации!");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            modelAndView.addObject("errorMsg", "Уважаемый " + user.getName() +  ", у Вас нет доступа к запрашиваемой странице!");
        }else{
            modelAndView.addObject("Нет доступа к запрашиваемой странице!");
        }
        modelAndView.setViewName("/content/accessDenied");
        return modelAndView;
    }

    private void printUserDetails() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("user=" + userDetails.getUsername());
        LOGGER.info("password=" + userDetails.getPassword());
        LOGGER.info("Права:");
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            LOGGER.info(authority.getAuthority());
        }
    }

}
