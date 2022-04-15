package com.gg.Login;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginDAO dao;
	
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public LoginDTO checkLogin(LoginDTO dto) {
		List<LoginDTO> userList = dao.userList(session, dto.getUser_code());
		
		// userList중에 dto가 존재하는지 검사
		for(int i=0;i<userList.size();i++) {
			// 존재하면 그 dto 반환
			if(userList.get(i).getID().equals(dto.getID()) &&
					userList.get(i).getPW().equals(dto.getPW()) &&
					userList.get(i).getUser_code() == dto.getUser_code())
				return dto;
		}
		
		return null;	// 존재하지 않으면 null 반환		
	}
}
