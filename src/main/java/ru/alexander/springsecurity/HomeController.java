package ru.alexander.springsecurity;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage() {
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
        }
        modelAndView.setViewName("/content/accessDenied");
        return modelAndView;
    }

}
