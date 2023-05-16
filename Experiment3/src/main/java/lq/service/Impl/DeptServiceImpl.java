package lq.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lq.entity.Dept;
import lq.mapper.DeptMapper;
import lq.service.DeptService;
import lq.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 107-90
 * @description 针对表【sys_dept(部门表)】的数据库操作Service实现
 * @createDate 2023-03-29 11:27:15
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
        implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<DeptVo> getDeptTree() {
        List<Dept> depts = baseMapper.selectList(null);
        List<DeptVo> deptVos = depts.stream().filter(d -> d.getParentId() == 0)
                .map(d -> {
                    DeptVo deptVo = new DeptVo();
                    deptVo.setId(d.getDeptId());
                    deptVo.setLabel(d.getDeptName());
                    deptVo.setChildren(getChildren(deptVo, depts));
                    return deptVo;
                }).collect(Collectors.toList());
        return deptVos;
    }

    @Override
    public Page<Dept> selectPageVo(Page<Dept> page, Long deptid) {
        deptMapper.selectPageVo(page,deptid);
        return page;
    }

    @Override
    public boolean deleteDeptById(Long deptId) {
        return false;
    }

    private List<DeptVo> getChildren(DeptVo deptVo, List<Dept> depts) {
        List<DeptVo> vos = depts.stream().filter(d -> deptVo.getId() == d.getParentId())
                .map(d -> {
                    DeptVo vo = new DeptVo();
                    vo.setId(d.getDeptId());
                    vo.setLabel(d.getDeptName());
                    vo.setChildren(getChildren(vo, depts));
                    return vo;
                }).collect(Collectors.toList());

        return vos.size()==0?null:vos;
    }

    @Override
    public boolean hasChildren(Long deptId) {
        int count = deptMapper.countChildrenDeptById(deptId);
        return count > 0;
    }

}
