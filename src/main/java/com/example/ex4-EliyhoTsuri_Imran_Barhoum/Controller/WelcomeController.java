package com.example.ex4.Controller;
import com.example.ex4.Bean.myUser;
import com.example.ex4.Entity.Users;
import com.example.ex4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/*
 * The department receives from the user a username to register
 * on the site and checks whether the received username can be
 * received, if it does not display an error message and if
 * so adds the user and displays an reception message
 */
@Controller
@RequestMapping("/Chat")
public class WelcomeController
{
    @Autowired
    UserRepository userRepository;
    @Resource(name = "sessionBeanExam")
    myUser userSession;
    @Transactional
    @PostMapping("/saveUser")

    public String tryLogin(@RequestParam String username , Model model)
    {
        System.out.println(userSession.getUser().getUserName() + userSession);
        System.out.println("#######$$$$$");
        userSession.getUser().setUserName(username);
        model.addAttribute("userName",username);
        Users user = userRepository.findByUserName(username);

        if(user == null)
        {
            System.out.println("user == null");
            Users user1 = new Users();
            user1.setUserName(username);
            user1.setAvailable(true);
            userRepository.save(user1);
        }
        else if (user.getAvailable())
        {
            System.out.println("user.getAvailable()="+user.getAvailable());
            model.addAttribute("notAvailable",false);
            model.addAttribute("message","try another one");
            return "login";
        }
        else
            System.out.println("elseAll" + user.getAvailable());
        return "redirect:/Chat/getWelcome";
    }
    @GetMapping("/getWelcome")
    public String getWelcome( Model model)
    {
        if(userSession.getUser().getUserName() == null)
            return "redirect:/";
        model.addAttribute("userName",userSession.getUser().getUserName());
        return "welcome";
    }
    @PostMapping("/getUserAvailable")
    public @ResponseBody List<Users> getUserAvailable()
    {
        return (List<Users>) userRepository.findByAvailableTrue();
    }
}