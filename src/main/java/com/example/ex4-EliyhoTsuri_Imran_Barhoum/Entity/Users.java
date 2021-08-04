package com.example.ex4.Entity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/*
 * The department is responsible for the users
 * who are absorbed into the site
 */
@Entity
public class Users implements Serializable
{
    @GeneratedValue
    @Id
    public int in_id;
    @NotBlank
    public String userName;
    @CreationTimestamp
    public Date dateCreate;
    public Boolean available;

    public Boolean getAvailable()
    {
        return available;
    }
    public void setAvailable(Boolean available)
    {
        this.available = available;
    }
    public int getIn_id()
    {
        return in_id;
    }
    public void setIn_id(int in_id)
    {
        this.in_id = in_id;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public Date getDateCreate()
    {
        return dateCreate;
    }
    public void setDateCreate(Date dateCreate)
    {
        this.dateCreate = dateCreate;
    }
}
