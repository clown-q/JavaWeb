import lq.entity.User;
import lq.mapper.UserMapper;
import lq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MybatisTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindUserById(){
        User user = userService.findUserById(1l);
        System.out.println(user);
    }
    @Test
    public void testFindUserByUsername(){
        User user = userMapper.findUserByUsername("zhangsan");
        System.out.println(user);
        User user1 = userMapper.findUserByUsername("zhangsan'#");
        System.out.println(user1);
    }
    @Test
    public void testFindUserByNameAndPass(){
        User user = userMapper.findUserByUsernameAndPassword("zhangsan","1234");
        System.out.println(user);
        User user1 = userMapper.findUserByUsernameAndPassword("zhansan'#","123");
        System.out.println(user1);
    }
    @Test
    public void testFindUserByMap(){
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("username","zhangsan");
        userMap.put("password","123456");
        User user = userMapper.findUserByMap(userMap);
        System.out.println(user);
    }
    @Test
    public void testFindUserList(){
        User user = new User();
        user.setEmail("xcu.edu.cn");
        List<User> users = userMapper.findUserByEmail(user);
        users.forEach(System.out::println);
    }
    @Test
    public void testFindUserWithIdCard(){
        User user = userMapper.findUserWithIdCard(1l);
        System.out.println(user);
    }
    @Test
    public void testFindUserWithIdCard1(){
        User user = userMapper.findUserWithIdCard1(1l);
        System.out.println(user);
    }

    @Test
    public void testFindUserWithRoles(){
        User user = userMapper.findUserWithRoles(2l);
        System.out.println(user);
    }

    @Test
    public void testFindUserWithRoles1(){
        User user = userMapper.findUserWithRoles1(2l);
        System.out.println(user);
    }

    @Test
    public void testFindUserDynameic(){
        User user = new User();
        user.setUsername("zhang");
        user.setEmail("zhangsan@xcu.edu.cn");
        user.setAge(19);
        //List<User> users = userMapper.findUsers(null);
        List<User> users = userMapper.findUsers(user);
        users.forEach(System.out::println);
    }

    @Test
    public void testFindUsersByChoose(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setEmail("zhansan@xcu.edu.cn");
        user.setAge(19);
        List<User> users = userMapper.findUsersByChoose(user);
        users.forEach(System.out::println);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(4l);
        user.setUsername("zhaosi");
        user.setAge(20);
        userMapper.updateUser(user);
        System.out.println(user);
    }

    @Test
    public void testInsertUser1(){
        User user = new User();
        user.setUsername("aaaaaa");
        user.setPassword("111111");
        user.setEmail("aaaa@xcu.edu.cn");
        userMapper.insertUser1(user);
        System.out.println(user);
    }

    @Test
    public void testInsertUsers(){
        User user = new User();
        user.setUsername("bbb");
        user.setPassword("222222");
        user.setEmail("bbb@xcu.icu");
        user.setAge(19);
        User user1 = new User();
        user1.setUsername("ccc");
        user1.setPassword("333333");
        user1.setEmail("ccc@xcu.icu.lq");
        user1.setAge(18);

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        userMapper.insertUser1s(users);
    }

    @Test
    public void testdeleteUserById(){
        Long[] ids = {9l,10l};
        userMapper.deleteByid(ids);
    }
}
