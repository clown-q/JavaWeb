package lq.service;

import lq.entity.Post;

import java.util.List;

public interface UserPostService {
    public boolean deleteByUserId(Long userId);
    public List<Post> getPostListByUserId(Long userId);
}
