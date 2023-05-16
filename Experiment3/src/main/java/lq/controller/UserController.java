package lq.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lq.entity.Dept;
import lq.entity.Post;
import lq.entity.Role;
import lq.mapper.UserMapper;
import lq.service.DeptService;
import lq.service.UserPostService;
import lq.service.UserRoleService;
import lq.service.UserService;
import lq.utils.R;
import lq.vo.DeptVo;
import lq.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lq.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserPostService userPostService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/deptTree")
    @ResponseBody
    public R<List<DeptVo>> getDeptTree(){
        List<DeptVo> deptVos=deptService.getDeptTree();
        return R.ok(deptVos);
    }

    @GetMapping("/list")
    @ResponseBody
    public String getUserList(@RequestParam("pageNum") int pageNum,
                                  @RequestParam("pageSize") int pageSize,
                                  @RequestParam(required = false) Long deptId) {
        Page<User> page = new Page<>(pageNum,pageSize);
        Page<Dept> page1 = new Page<>(pageNum,pageSize);
        if(deptId!=null){
            deptService.selectPageVo(page1,deptId);
            return JSON.toJSONString(page1);
        }
        else {
            userService.page(page);
            return JSON.toJSONString(page);
        }
    }

    @PostMapping("")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        userService.save(user);
        return "User added successfully";
    }

    @DeleteMapping("/{userId}")
    @ResponseBody
    public String deleteUser(@PathVariable Long userId) {
        // 先删除用户关联的角色信息
        userRoleService.deleteByUserId(userId);
        // 再删除用户关联的岗位信息
        userPostService.deleteByUserId(userId);
        // 最后删除用户
        userService.removeById(userId);
        return "User deleted successfully";
    }

    @GetMapping("/{userId}")
    public R<UserVo> getUserInfo(@PathVariable("userId") Long userId) {
        // 获取用户信息
        User user = userService.getById(userId);
        // 获取角色列表
        List<Role> roleList = userRoleService.getRoleListByUserId(userId);

        // 获取岗位列表
        List<Post> postList = userPostService.getPostListByUserId(userId);

        // 构建返回结果
        UserVo userInfo = new UserVo();
        userInfo.setUser(user);
        userInfo.setRoleList(roleList);
        userInfo.setPostList(postList);

        return R.ok(userInfo);
    }
    @PutMapping("")
    @ResponseBody
    public R<User> updateUser(@RequestBody User user) {
        User oldUser = userMapper.selectUserById(user.getUserId());
        oldUser.setUserName(user.getUserName());
        oldUser.setNickName(user.getNickName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhonenumber(user.getPhonenumber());
        oldUser.setSex(user.getSex());
        oldUser.setAvatar(user.getAvatar());
        oldUser.setPassword(user.getPassword());
        oldUser.setStatus(user.getStatus());
        oldUser.setDelFlag(user.getDelFlag());
        oldUser.setUpdateTime(LocalDateTime.now());
        System.out.println(oldUser);
        userService.updateUser(oldUser);
        return R.ok();
    }

}
