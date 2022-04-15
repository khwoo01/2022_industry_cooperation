package com.gg.jobPosting;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public interface PostDAO {
    public abstract List<PostDTO> postList(SqlSessionTemplate session);
}
