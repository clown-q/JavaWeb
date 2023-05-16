package lq;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lq.entity.User;
import lq.mapper.UserMapper;
import lq.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Experiment3ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void pageTest(){
        Page<User> page = new Page<>(1, 3);
        userService.page(page);
        System.out.println(JSON.toJSONString(page));
    }

//    利用条件构造器查询部门id为105且邮箱为xcu.edu.cn或者性别为1的用
//    户信息，且只查询userId，deptId、userName、nickName、
//    email、phoneNumber字段，按userId进行降序排列

//    使用QueryWrapper实现
    @Test
    public void testWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_id","dept_id","user_name","nick_name","email","phonenumber")
                .eq("dept_id",105l)
                .and(u->u.like("email","xcu.edu.cn")
                        .or()
                        .eq("sex","1"))
                .orderByDesc("user_id");
        List<User> users = userMapper.selectList(wrapper);
        users.stream().forEach(System.out::println);
    }

//    使用LambdaQueryWrapper实现
    @Test
    public void testLambdaWrapper(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getUserId,User::getDeptId,User::getUserName,User::getNickName,User::getEmail,User::getPhonenumber)
                .eq(User::getDeptId,105l)
                .and(u->u.like(User::getEmail,"xcu.edu.cn")
                        .or()
                        .eq(User::getSex,"1"))
                .orderByDesc(User::getUserId);
        List<User> users = userMapper.selectList(wrapper);
        users.stream().forEach(System.out::println);
    }


    @Test
    public void pageTest2(){
        //查询ID大于等于100的用户列表分页
        Page<User> page = new Page<>(1, 5);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getUserId,100l);
        userService.page(page,wrapper);
        System.out.println(JSON.toJSONString(page));
    }


    @Test
    public void pageTest3(){
        //查询ID大于等于100的用户列表分页
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPageVo(page,"若");
        System.out.println(JSON.toJSONString(page));
    }
}
