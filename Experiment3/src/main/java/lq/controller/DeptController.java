package lq.controller;

import lq.service.DeptService;
import lq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @DeleteMapping("/{deptId}")
    public R<?> deleteDept(@PathVariable("deptId") Long deptId) {

        if (deptService.hasChildren(deptId)) {
            return R.error("该部门下存在子部门，无法删除");
        }
        boolean result = deptService.deleteDeptById(deptId);
        return result ? R.ok() : R.error("删除部门失败");
    }

}
