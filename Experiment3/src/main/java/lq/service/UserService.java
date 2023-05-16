package lq.service;

import lq.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 107-90
 * @description 针对表【sys_user(用户信息表)】的数据库操作Service
 * @createDate 2023-03-29 10:07:21
 */
public interface UserService extends IService<User> {
    public int updateUser(User user);
}
