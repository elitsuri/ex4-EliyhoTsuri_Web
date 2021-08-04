package com.example.ex4.Bean;
import com.example.ex4.Entity.Users;

import java.io.Serializable;

/*
 * This class ןs responsible for accepting new users admitted
 * to the program Set and get the new users
 */
public class myUser implements Serializable
{
    Users user;
    public myUser()
    {
        user = new Users();
    }
    public Users getUser()
    {
        return user;
    }
    public void setUser(Users user)
    {
        this.user = user;
    }
}
