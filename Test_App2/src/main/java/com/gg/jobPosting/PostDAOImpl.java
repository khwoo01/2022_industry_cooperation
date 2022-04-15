package com.gg.jobPosting;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAOImpl implements PostDAO{
    @Override
	public List<PostDTO> postList(SqlSessionTemplate session) {
		return session.selectList("UserMapper.postList");
	}
}
