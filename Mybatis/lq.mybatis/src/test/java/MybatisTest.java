import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lq.entity.User;
import lq.mapper.UserMapper;
import lq.service.UserService;

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
        User user2 = userMapper.findUserByUsername("zhangsan'#");
        System.out.println(user2);
    }

    @Test
    public void testFindUserByNameAndPass(){
        User user=userMapper.findUserByUsernameAndPassword("zhangsan","1234");
        System.out.println(user);
        User user2=userMapper.findUserByUsernameAndPassword("zhangsan'#","123");
        System.out.println(user2);
    }

    @Test
    public void testFindUserByMap(){
        Map<String,Object> userMap=new HashMap<>();
        userMap.put("username","zhangsan");
        userMap.put("password","123456");
        User user = userMapper.findUserByMap(userMap);
        System.out.println(user);
    }

    @Test
    public void testFindUserlist(){
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
    public void testFindUserWithIdCard2(){
        User user = userMapper.findUserWithIdCard2(1l);
        System.out.println(user);
    }
}
