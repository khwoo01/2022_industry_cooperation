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
		System.out.println("   pos.posNO   : " + dto.getPOST_NO());
		System.out.println("   pos.co_id    : " + dto.getCO_ID());
		System.out.println("   pos.position    : " + dto.getPOSITION());
		System.out.println("   pos.qualify    : " + dto.getQUALIFY());
		System.out.println("   pos.job    : " + dto.getJOB());
		System.out.println("   pos.EMPLOY_TYPE     : " + dto.getEMPLOY_TYPE());
		System.out.println("   pos.REGI_DT    : " + dto.getREGI_DT());
		System.out.println("   pos.CO_NO    : " + dto.getCO_NO());

		service.insertPos(dto);
	}

}
