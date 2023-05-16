package lq.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lq.entity.User;
import org.apache.ibatis.annotations.Mapper;
import lq.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description 针对表【sys_dept(部门表)】的数据库操作Mapper
 * @Entity lq.entity.Dept
 */

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
    public Page<Dept> getDeptPage(@Param("page") Page<Dept> page, @Param("deptid") Long deptid);
    Page<Dept> selectPageVo(@Param("page") Page<Dept> page, @Param("deptid") Long deptid);

    int countChildrenDeptById(Long deptId);
}
