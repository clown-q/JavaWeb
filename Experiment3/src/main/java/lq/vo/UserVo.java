package lq.vo;

import lombok.Data;
import lq.entity.Post;
import lq.entity.Role;
import lq.entity.User;

import java.util.List;

@Data
public class UserVo {
        private User user;
        private List<Role> roleList;
        private List<Post> postList;

}
