package xcu.dao;

import xcu.entity.User;

public interface UserDao {
    public User findUserById(Long id);
}
