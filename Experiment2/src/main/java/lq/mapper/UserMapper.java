package lq.mapper;

import lq.entity.User;
import lq.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public User findUserById(Long id);

    public int insertUser(User user);

    public Long findIdByusername(String username);

    public int updateUsers(User user);

    public void delUserByid(Long id);

    public Long findidCardById(Long id);
    public List<UserVo> findAllUser();
}