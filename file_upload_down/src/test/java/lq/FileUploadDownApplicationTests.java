package lq;

import lq.domain.Myproperties;
import lq.domain.Person2;
import lq.domain.Student;
import lq.domain.User;
import lq.service.MyService;
import lq.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FileUploadDownApplicationTests {

    @Autowired
    private Person2 person2;
    @Autowired
    private Myproperties myproperties;
    @Autowired
    private MyService myService;
    @Autowired
    private UserService userService;
    @Autowired
    private Student student;
    @Test
    void contextLoads() {
        System.out.println(person2);

    }
    @Test
    public void testMyproperties(){
        System.out.println(myproperties);
    }
    @Test
    public void testMyService(){
        myService.say();
    }

    @Test
    public void testUser(){
        List<User> list = userService.list();
        System.out.println(list);
    }
    @Test
    public void testStudent(){
        System.out.println(student);
    }

}
