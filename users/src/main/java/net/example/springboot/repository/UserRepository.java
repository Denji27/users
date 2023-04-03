package net.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.example.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserName(String userName);
}
