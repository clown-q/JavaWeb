package lq.mapper;

import lq.entity.IdCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import lq.entity.User;

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
    public User findUserWithIdCard2(Long id);
}
