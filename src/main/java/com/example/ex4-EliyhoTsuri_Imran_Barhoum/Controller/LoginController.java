package com.example.ex4.Controller;
import com.example.ex4.Bean.myUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
/*
 * The class receives new users for the site
 * and displays the relevant messages
 */

@Controller
public class LoginController
{
    @Resource(name = "sessionBeanExam")
    myUser userSession;
    @GetMapping("/")

    public String Login(Model model)
    {
        if (userSession.getUser().getUserName() != null)
        {
            return "redirect:/Chat/getWelcome";
        }
        model.addAttribute("message","Hello to Chat");
        model.addAttribute("notAvailable",true);
    return "login";
    }
}
