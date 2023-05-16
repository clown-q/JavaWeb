package lq.mapper;

import lq.entity.User;
import lq.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    public User findUserById(Long id);
    public User findUserByUsername(String username);
    public User findUserByUsernameAndPassword(String username,String password);
    public User findUserByMap(@Param("userMap") Map userMap);
    public List<User> findUserByEmail(User user);
    public User findUserWithIdCard(Long id);
    public User findUserWithIdCard1(Long id);
    public User findUserWithRoles(Long id);
    public User findUserWithRoles1(Long id);
    public List<User> findUsers(User user);
    public List<User> findUsersByChoose(User user);
    public int updateUser(User user);
    public int insertUser1(User user);
    public int insertUser1s(@Param("users") List<User> users);
    public int deleteByid(@Param("ids")Long[] ids);



    public int insertUser(User user);
    public Long findIdByusername(String username);

    public User findUserByIds(Long id);

    public int updateUsers(User user);

    public void delUserByid(Long id);

    public List<UserVo> findAllUser();
}
