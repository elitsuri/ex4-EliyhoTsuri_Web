package com.example.ex4.Controller;
import com.example.ex4.Entity.Message;
import com.example.ex4.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
 * The class receives from the user a message name or a username
 * then searches and displays the required request respectively
 */
@Controller
@RequestMapping("/Chat")
public class SearchController
{
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/Search")
    public String Search()
    {
        return "search";
    }
    @RequestMapping("/SearchByMsg")
    public String SearchByMsg(String msg , Model model)
    {
        List<Message> list = messageRepository.findByMessage(msg);
        System.out.println("SearchByMsg + list.size()" + list.size());
        if (list.size() == 0)
                list =null;
        model.addAttribute("messages",list);
    System.out.println("SearchByMsg message" + msg);
    return "search";
    }
    @RequestMapping("/SearchByUsr")
    public String SearchByUsr(String user , Model model)
    {
        List<Message> list = messageRepository.findByUserName(user);
        System.out.println("SearchByUsr + list.size()"+list.size());
        if (list.size() == 0)
            list =null;
        model.addAttribute("messages",list);
        System.out.println("SearchByUsr " + user);
        return "search";
    }
}