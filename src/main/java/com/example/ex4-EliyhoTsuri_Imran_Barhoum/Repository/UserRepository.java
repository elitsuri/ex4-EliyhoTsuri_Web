package com.example.ex4.Repository;
import com.example.ex4.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>
{
    Users findByUserName(String userName);
    List<Users> findByAvailableTrue();
}
