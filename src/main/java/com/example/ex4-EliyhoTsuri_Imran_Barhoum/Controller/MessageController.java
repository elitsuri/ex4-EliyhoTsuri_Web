package com.example.ex4.Controller;
import com.example.ex4.Bean.LastMessage;
import com.example.ex4.Entity.Message;
import com.example.ex4.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/*
 * The class receives from the new users input messages to
 * the chat and then saves and prints the name of the user and
 * the content of the message he wrote, respectively.
 */
@Controller
@RequestMapping("/Chat")
public class MessageController
{
    @Autowired
    MessageRepository messageRepository;
    @Resource(name = "lastIdMessage")
    LastMessage lastIdMessage;

    @Transactional
    @PostMapping("/newMsg")
    public String newMsg(@RequestParam("msg") String msg,@RequestParam("user") String user , Model model)
    {
        Message message  =new Message();
        message.setMessage(msg);
        System.out.println(user + "#####################################3");
        message.setUserName(user);
        messageRepository.save(message);
        model.addAttribute("messege",msg);
        return "redirect:/Chat/getWelcome";
    }

    @Transactional
    @PostMapping("/getMessages")
    public @ResponseBody List<Message> getMessages()
    {
        return messageRepository.findTop5ByOrderByIdDesc();
    }
    @Transactional
    @PostMapping ("/getLastIdMessage")
    public @ResponseBody Message getLastIdMessage()
    {
        Message msg  = messageRepository.findTop1ByOrderByIdDesc();
        if(msg == null)
            return null;
        System.out.println("msg.id: " + msg.id);
        System.out.println("lastIdMessage.getMessage().getId() " +lastIdMessage.getMessage().getId());
        if( msg.id > lastIdMessage.getMessage().getId())
            lastIdMessage.getMessage().setId(msg.id);
        else
            msg.id =0;
        System.out.println();
        return msg;
    }
}