package lq.mapper;

import lq.entity.Role;
import lq.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
 * @Entity lq.entity.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public Page<User> getUserPage(@Param("page") Page<User> page,@Param("email") String email);
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("nickName") String nickName);

    int updateUser(User user);
    @Insert("INSERT INTO sys_user_dept (user_id, dept_id) VALUES (#{userId}, #{deptId})")
    void insertUserDept(@Param("userId") Long userId, @Param("deptId") Long deptId);

    User selectUserById(Long userId);
    int insertUserRoles(@Param("userId") Long userId, @Param("roles") List<Role> roles);
    public int deleteUserRole(Long userId);


    public int updateUsers(User user);
}
