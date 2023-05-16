package xcu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xcu.dao.UserDao;
import xcu.entity.User;

@Repository("UserDao")
public class UserDaoimpl implements UserDao {
    @Autowired
    private User user;
    @Override
    public User findUserById(Long id) {
        return this.user;
    }
}
