package com.smarthub.mpg.controller;

import com.smarthub.mpg.UserService;
import com.smarthub.mpg.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(@ModelAttribute User user, ModelMap model) {

        model.addAttribute("message", "Hello World!");
        model.addAttribute("date", new Date());

        logger.info("Returning hello view");

        return "hello/index";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(@ModelAttribute User user, BindingResult result)
            throws ServletException, IOException {

        if(result.hasErrors()) {
            return "hello";
        }


        logger.info("Returning hello view");

        return "redirect:show/1";
    }

    @RequestMapping(value="show/{data}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable String data, Model model)
            throws ServletException, IOException {

        logger.info("Returning show view" + data);
        ModelAndView modelAndView = new ModelAndView("hello/show");
        modelAndView.addObject("user", userService.getUserById(1L));
        return modelAndView;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}