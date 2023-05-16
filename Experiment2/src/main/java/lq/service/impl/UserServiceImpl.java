package lq.service.impl;

import lq.entity.IdCard;
import lq.entity.User;
import lq.entity.UserRole;
import lq.mapper.IdCardMapper;
import lq.mapper.UserMapper;
import lq.mapper.UserRoleMapper;
import lq.service.UserService;
import lq.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.IdentityHashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdCardMapper idCardMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public User findUserById(Long id) {

        return userMapper.findUserById(id);

    }

    @Override
    public User addUser(UserVo userVo) {
        //插入t_idcard
        IdCard idCard = new IdCard();
        idCard.setCode(userVo.getCode());//这里获取uservo的code的值作为idCard.code
        System.out.println(idCard);
        idCardMapper.insertIdCard(idCard.getCode());//这里没有自主设置t_idcard的id值，设置为自增

        //插入t_user表
        User user = new User();
        user.setUsername(userVo.getUsername());//这里获取uservo的值对应为user的值
        user.setPassword(userVo.getPassword());
        user.setAge(userVo.getAge());
        user.setEmail(userVo.getEmail());
        user.setIdCard(idCardMapper.findIdByCode(idCard.getCode()));
//        System.out.println(user);
        int result = userMapper.insertUser(user);

        //插入到t_user_role表
        UserRole userRole = new UserRole();
        userRole.setUserId(userMapper.findIdByusername(userVo.getUsername()));
        userRole.setRoleId(userVo.getRoleId());
        System.out.println(userRole);
        userRoleMapper.insertUserRole(userRole);

        return user;
    }

    @Override
    public int updateUser(User user) {
        int result = userMapper.updateUsers(user);
        return result;
    }

    @Override
    public void delUser(Long id) {
        Long idcard = userMapper.findidCardById(id);
        userMapper.delUserByid(id);
        userRoleMapper.deluserRoleByUserId(id);
        idCardMapper.delIdCardByid(idcard);
    }

    @Override
    public List<UserVo> findAllUser() {

        return userMapper.findAllUser();
    }
}