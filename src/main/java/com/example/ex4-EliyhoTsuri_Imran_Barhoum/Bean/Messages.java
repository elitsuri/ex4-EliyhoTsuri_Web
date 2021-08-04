package com.example.ex4.Bean;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * This class is the Messages class and set, get the Messages.
 */
public class Messages implements Serializable
{
    ArrayList<String> messages;
    Messages()
    {
        this.messages = new ArrayList<>();
    }
    public ArrayList<String> getMessages()
    {
        return messages;
    }
    public void setMessages(ArrayList<String> messages)
    {
        this.messages = messages;
    }
    public void add(String msg)
    {
        messages.add(msg);
    }
}
