package com.example.ex4.Controller;
import com.example.ex4.Bean.myUser;
import com.example.ex4.Entity.Users;
import com.example.ex4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*
 * The class receives a username from the user and then
 * disconnects that username from the program
 */
@Controller
@RequestMapping("/Chat")
public class SessionController
{
@Resource(name = "sessionBeanExam")
myUser userSession;

    @Autowired
    UserRepository userRepository;
    @RequestMapping("/logout")
    public String Logout(HttpServletRequest request)
    {
        Users user = userRepository.findByUserName(userSession.getUser().getUserName());
        user.setAvailable(false);
        request.getSession().invalidate();
        System.out.println("Logout");
        return "redirect:/";
    }
}