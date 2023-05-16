package lq.vo;

import lombok.Data;

import java.util.List;

@Data
public class DeptVo {
    private Long id;
    private String label;
    private List<DeptVo> children;
}
