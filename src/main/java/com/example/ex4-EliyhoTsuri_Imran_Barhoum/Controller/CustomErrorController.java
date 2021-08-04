package com.example.ex4.Controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * This class belongs to the Controller class and
 * is responsible for the error messages
 */

@Controller
public class CustomErrorController implements ErrorController
{
    @RequestMapping("/error")
    public String handleError()
    {
        return "error";
    }
}
