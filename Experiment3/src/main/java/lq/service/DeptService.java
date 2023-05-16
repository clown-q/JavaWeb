package lq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lq.entity.Dept;
import lq.vo.DeptVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 针对表【sys_dept(部门表)】的数据库操作Service
 */
public interface DeptService extends IService<Dept> {

    public List<DeptVo> getDeptTree();
    Page<Dept> selectPageVo(@Param("page") Page<Dept> page, @Param("deptid") Long deptid);
    boolean deleteDeptById(Long deptId);

    boolean hasChildren(Long deptId);

}
