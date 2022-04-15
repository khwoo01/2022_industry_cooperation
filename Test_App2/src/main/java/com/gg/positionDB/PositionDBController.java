package com.gg.positionDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class PositionDBController {
	@Autowired
	PositionDBService service;
	
	@PostMapping("/register-position")
	public void InsertPos(@RequestBody PositionDBDTO dto) {
		System.out.println("***Pos Controller..***");
		System.out.println("   pos.posName    : " + dto.getPOSITION());
		System.out.println("   pos.qualify    : " + dto.getQUALIFY());
		System.out.println("   pos.employType : " + dto.getEMPLOY_TYPE());
		
		service.insertPos(dto);
	}
}
