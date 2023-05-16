package lq.mapper;

import lq.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    public int insertUserRole(UserRole userRole);

    public void deluserRoleByUserId(Long id);
}
