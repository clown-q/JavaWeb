package lq.service;

import lq.entity.Role;

import java.util.List;

public interface UserRoleService {
    public boolean deleteByUserId(Long userId);
    public List<Role> getRoleListByUserId(Long userId);
}
