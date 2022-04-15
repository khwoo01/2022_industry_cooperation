package com.gg.Login;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO{
	@Override
	public List<LoginDTO> userList(SqlSessionTemplate session, int user_code) {
		// login시도한 계정의 user_code확인
		if(user_code == 0) {	// 개인회원인 경우
			return session.selectList("UserMapper.loginIndv");	// 개인 table select
		}
		else if(user_code == 1){	// 기업회원인 경우
			return session.selectList("UserMapper.loginComp");	// 기업 table select
		}
		else {
			return null;	// 그 외의 경우는 오류이므로 null 반환
		}
	}
}
