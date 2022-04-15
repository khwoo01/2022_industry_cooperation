package com.gg.jobPosting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PostController {
    @Autowired
	PostService service;
	
	@GetMapping("/job-posting")
	public List<PostDTO> SelectAllFromPost() {
		System.out.println("-----------------------------");
		System.out.println("    Post Controller..");
		System.out.println("-----------------------------");
		List<PostDTO> a = service.postList();
		System.out.println("company :" + a.get(0).COMPANY);
		return service.postList();
	}
}
