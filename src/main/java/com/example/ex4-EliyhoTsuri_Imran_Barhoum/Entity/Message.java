package com.example.ex4.Entity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

/*
 * The class is responsible for the notifications
 * for all users in the program
 */
@Entity
public class Message
{
    @GeneratedValue
    @Id
    public int id;
    private String userName;
    @NotBlank
    private String message;
    @CreationTimestamp
    public Date createAt;
    @UpdateTimestamp
    public Date updateAt;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public Date getCreateAt()
    {
        return createAt;
    }
    public void setCreateAt(Date createAt)
    {
        this.createAt = createAt;
    }
    public Date getUpdateAt()
    {
        return updateAt;
    }
    public void setUpdateAt(Date updateAt)
    {
        this.updateAt = updateAt;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
}