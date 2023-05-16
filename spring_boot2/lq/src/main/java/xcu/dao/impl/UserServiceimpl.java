package xcu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcu.dao.UserDao;
import xcu.dao.UserService;
import xcu.entity.User;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }
}
