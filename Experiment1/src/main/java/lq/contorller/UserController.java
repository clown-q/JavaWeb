package lq.contorller;

import lq.entity.User;
import lq.service.UserService;
import lq.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){

        return "hello";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id")Long id){

        return userService.findUserById(id);
    }

    @GetMapping("/add")
    @ResponseBody
    public String addUser(){
        UserVo userVo = new UserVo();
        userVo.setUsername("liuqi");
        userVo.setPassword("5013210109");
        userVo.setAge(19);
        userVo.setCode("1111111");
        userVo.setEmail("blog.xcu.icu");
        userVo.setRoleId(1l);
        userService.saveUser(userVo);
        return "用户插入成功"+userVo;
    }
    @GetMapping("/query/{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id")Long id){

        return userService.findUserById1(id);

    }
    @GetMapping("/update/{id}")
    @ResponseBody
    public String updateUser(@PathVariable("id")Long id){
        UserVo userVo = new UserVo();
        userVo.setUsername("liuqi");
        userVo.setPassword("5013210109");
        userVo.setAge(20);
        userVo.setEmail("blog.xcu.icu");
        userVo.setId(id);
        userService.updateUser(userVo);
        return "更新成功"+userVo;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<UserVo> findAllUser(){
        return userService.findAllUser();
    }
    @GetMapping("/del/{id}")
    @ResponseBody
    public String delUser(@PathVariable("id")Long id){
        userService.delUser(id);
        return "删除成功，删除的目标id是"+id;
    }
}