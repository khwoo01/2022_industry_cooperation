package com.gg.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	LoginService service;

	// �α���
	@PostMapping("/login")
	public boolean Login(@RequestBody LoginDTO dto,
			HttpServletRequest request) {

		System.out.println("***Login Controller..***");
		System.out.println(" input ID: " + dto.getID());
		System.out.println(" input PW: " + dto.getPW());
		System.out.println(" input uc: " + dto.getUser_code());
		System.out.println(" @@@@@@@");

		LoginDTO loginUser = service.checkLogin(dto);
		System.out.println(" @@@@@@@" + loginUser);
		if (loginUser == null) { // �α��� ������ ���
			System.out.println(" login failed...");
			return false;
		} else { // �α��� ������ ���
			System.out.println(" login success! getting session...");
			HttpSession session = request.getSession(); // ������ ������ �ִ� ���� ��ȯ, ������ �ű� ������ �����Ͽ� ��ȯ
			session = request.getSession();
			session.setAttribute("loginUser", loginUser.getID()); // ���ǿ� �α��� ȸ�� ���� ����
			session.setAttribute("usercode", loginUser.getUser_code());
			System.out.println(" complete login!!:" + session.getAttribute("loginUser"));
			return true;
		}
	}

	// �α׾ƿ�
	@PostMapping("/logout")
	public void logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate(); // ���� ����
		}
	}

	// �α��� ���� �˻�
	@PostMapping("/check-session")
	public String checkSession(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			return session.getAttribute("loginUser").toString();
		}
		return null;
	}

	// �α��� �����ڵ� �˻�
	@PostMapping("/check-usercode")
	public boolean isCompUser(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println(session.getAttribute("usercode").toString());
			return session.getAttribute("usercode").toString().equals("1");
		}
		return false;
	}
}
