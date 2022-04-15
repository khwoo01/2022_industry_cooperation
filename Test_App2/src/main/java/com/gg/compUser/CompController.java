package com.gg.compUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CompController {
	@Autowired
	CompService service;

	@PostMapping("/success-join-comp")
	public void InsertCompUser(@RequestBody CompDTO dto){

		System.out.println("***Comp Controller..***");
		System.out.println("   comp.name     : " + dto.COMPANY);
		System.out.println("   comp.category : " + dto.CATEGORY_ID);
		System.out.println("   comp.size     : " + dto.SIZE_ID);

		service.insertComp(dto);
	}
	
	// 기업 회원 마이페이지 조회
		@GetMapping("/mypage-comp")
		public CompDTO getCompUser(String userID) {
		    CompDTO dto = service.getComp(userID);
		    System.out.println("***Comp Controller..***");
			System.out.println("   comp.name   : " + dto.getCOMPANY());
		    return dto;
		}
}
