package lq.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lq.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<Post> {
    List<Post> selectPostsByUserId(@Param("userId") Long userId);
    @Select("select * from sys_post where post_id in (select post_id from sys_user_post where user_id = #{userId})")
    List<Post> selectListByUserId(Long userId);
}
