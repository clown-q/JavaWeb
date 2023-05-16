package lq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lq.entity.User;
import lq.mapper.UserMapper;
import lq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 107-90
 * @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
 * @createDate 2023-03-29 10:07:21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int updateUser(User user) {
        int result = userMapper.updateUsers(user);
        return result;
    }
}
