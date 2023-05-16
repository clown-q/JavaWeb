package lq.service;

import lq.entity.User;
import lq.vo.UserVo;

import java.util.List;

public interface UserService {
    public User findUserById(Long id);
    public int saveUser(UserVo userVo);
    public User findUserById1(Long id);
    public int updateUser(UserVo userVo);

    public void delUser(Long id);


    public List<UserVo> findAllUser();
}
