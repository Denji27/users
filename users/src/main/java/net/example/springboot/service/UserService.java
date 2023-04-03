package net.example.springboot.service;

import net.example.springboot.entity.Role;
import net.example.springboot.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUser();
}
