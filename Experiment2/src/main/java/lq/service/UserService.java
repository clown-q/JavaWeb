package lq.service;

import lq.entity.User;
import lq.vo.UserVo;

import java.util.List;

public interface UserService {
    public User findUserById(Long id);

    public User addUser(UserVo userVo);

    public int updateUser(User user);

    public void delUser(Long id);

    public List<UserVo> findAllUser();
}