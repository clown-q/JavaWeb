package lq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lq.domain.User;
import lq.mapper.UserMapper;
import lq.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 107-90
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2023-04-12 10:02:18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}
