package com.example.ex4.Repository;

import com.example.ex4.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer>
{
    List<Message> findTop5ByOrderByIdDesc();
    Message findTop1ByOrderByIdDesc();
    List<Message> findByMessage(String Message);
    List<Message> findByUserName(String username);
}
