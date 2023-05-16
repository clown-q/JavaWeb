package lq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lq.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectRolesByUserId(@Param("userId") Long userId);
    List<Role> selectListByUserId(@Param("userId") Long userId);
}
