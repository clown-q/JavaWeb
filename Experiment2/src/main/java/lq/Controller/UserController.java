package lq.Controller;

import jakarta.validation.constraints.NotNull;
import lq.entity.User;
import lq.service.UserService;
import lq.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    @ResponseBody
    public User findUserById1(@PathVariable Long id){

        return userService.findUserById(id);

    }

    @PostMapping("/add")
    @ResponseBody
    public String addUserSubmit(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("age") Integer age,
                                @RequestParam("email") String email,
                                @RequestParam("RoleId") Long RoleId,
                                @RequestParam("Code") String Code) {
        UserVo uservo =new UserVo();
        uservo.setUsername(username);//user的username
        uservo.setPassword(password);//user的passwd
        uservo.setAge(age);//user的age
        uservo.setEmail(email);//user的email
        uservo.setCode(Code);//idcard的code
        uservo.setRoleId(RoleId);//user_role的roleid
        System.out.println(uservo);
        userService.addUser(uservo);
        return uservo+"添加成功";
    }

    @GetMapping("/query/{id}")
    public String findUserById(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "query";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateUser(@NotNull(message = "参数id不能为空") @RequestBody User user){
        User user1,user2 = new User();
        user1 = findUserById1(user.getId());//获取更新前的数据
        userService.updateUser(user);
        user2 = findUserById1(user.getId());
        System.out.println(user);
        return "改变前"+user1+"\n"+"改变后"+user2;
    }

    @GetMapping("/del/{id}")
    @ResponseBody
    public String delUser(@PathVariable("id")Long id){
        userService.delUser(id);
        return "删除成功，删除的目标id是"+id;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<UserVo> findAllUser(){
        return userService.findAllUser();
    }

}