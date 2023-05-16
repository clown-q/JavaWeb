package lq.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lq.entity.Post;
import lq.entity.UserPost;
import lq.mapper.PostMapper;
import lq.mapper.UserPostMapper;
import lq.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> getPostListByUserId(Long userId) {
        return postMapper.selectListByUserId(userId);
    }
    @Override
    public boolean deleteByUserId(Long userId) {
        QueryWrapper<UserPost> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return this.remove(wrapper);
    }
}
