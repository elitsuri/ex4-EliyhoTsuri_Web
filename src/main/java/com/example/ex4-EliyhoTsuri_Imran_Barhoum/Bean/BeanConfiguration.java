package com.example.ex4.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
/*
 * This class print the BeanConfiguration
 */
@Configuration
public class BeanConfiguration
{
    @Bean
    @SessionScope
    public com.example.ex4.Bean.myUser sessionBeanExam()
    {
        System.out.println(" BeanConfiguration");
        com.example.ex4.Bean.myUser u = new com.example.ex4.Bean.myUser();
        return u;
    }
    @Bean
    @SessionScope
    public com.example.ex4.Bean.LastMessage lastIdMessage()
    {
        com.example.ex4.Bean.LastMessage lastMessage = new com.example.ex4.Bean.LastMessage();
        lastMessage.message.id =0;
        return lastMessage;
    }
}