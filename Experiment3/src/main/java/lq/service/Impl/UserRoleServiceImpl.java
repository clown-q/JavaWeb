package lq.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lq.entity.Role;
import lq.entity.UserRole;
import lq.mapper.RoleMapper;
import lq.mapper.UserRoleMapper;
import lq.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public boolean deleteByUserId(Long userId) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return this.remove(wrapper);
    }


    @Override
    public List<Role> getRoleListByUserId(Long userId) {
        return roleMapper.selectListByUserId(userId);
    }
}