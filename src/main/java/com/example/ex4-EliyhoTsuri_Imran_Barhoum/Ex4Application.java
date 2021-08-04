package com.example.ex4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Ex4Application
{
    public static void main(String[] args) throws SQLException
    {
        SpringApplication.run(Ex4Application.class, args);

    }
}
