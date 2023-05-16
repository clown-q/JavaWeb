package lq.mapper;

import lq.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    public List<Role> findRolesByUserId(@Param("userId") Long userId);
}
