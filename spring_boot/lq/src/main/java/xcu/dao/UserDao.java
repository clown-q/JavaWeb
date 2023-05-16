package xcu.dao;

import xcu.entity.User;

import java.util.List;


public interface UserDao {
    public User findUserById(Long id);
    public List<User> findAllUsers();
}
