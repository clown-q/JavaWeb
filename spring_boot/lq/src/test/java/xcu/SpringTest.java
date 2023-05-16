package xcu;

import org.junit.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xcu.dao.UserDao;
import xcu.entity.User;

import java.util.List;


public class SpringTest {
    @Test
    public void first(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("beans.xml");
        User user = (User) factory.getBean("user");
        System.out.println(user);
    }
    @Test
    public void second(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("beans.xml");
        UserDao userDao= (UserDao) factory.getBean("userDao");
        User user = userDao.findUserById(1l);
        System.out.println(user);
    }
    @Test
    public void third(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) context.getBean("userDao");
        User user = userDao.findUserById(1l);
        System.out.println(user);
    }

    @Test
    public void fourth(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        User user= (User) context.getBean("lisi");
        System.out.println(user);
        User user2= (User) context.getBean("100101");
        System.out.println(user);
    }

    @Test
    public void scopeTest(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        User user= (User) context.getBean("user");
        System.out.println(user.hashCode());
        User user2= (User) context.getBean("user");
        System.out.println(user2.hashCode());
        User user3= (User) context.getBean("user2");
        System.out.println(user3.hashCode());
        User user4= (User) context.getBean("user2");
        System.out.println(user4.hashCode());
    }

    @Test
    public void constructorTest(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        User user= (User) context.getBean("user3");
        System.out.println(user);
    }

    @Test
    public void staticTest(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        User user= (User) context.getBean("user4");
        System.out.println(user);
    }

    @Test
    public void listTest(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) context.getBean("xcu.dao.impl.UserDaoimpl");
        List<User> users = userDao.findAllUsers();
        users.stream().forEach(System.out::println);
    }


}

