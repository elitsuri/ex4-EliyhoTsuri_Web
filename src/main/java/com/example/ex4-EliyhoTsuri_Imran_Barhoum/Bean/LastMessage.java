package com.example.ex4.Bean;
import com.example.ex4.Entity.Message;

/*
 * This class print the Last message
 */
public class LastMessage
{
    Message message;
    public LastMessage()
    {
        this.message = new Message();
        this.getMessage().setId(0);
    }

    public Message getMessage()
    {
        return message;
    }
    public void setMessage(Message message)
    {
        this.message = message;
    }
}
