package com.gg.jobDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class JobController {
    @Autowired
    JobService service;

    @PostMapping("/checkdetail")
    boolean JobDetail(@RequestBody JobDTO dto) {
        System.out.println(" input uc: " + dto.getPOST_NO());
        return true;
    }

    @GetMapping("/jobdetail")
    public JobDTO getDetail(int post_NO) {
        JobDTO dto = service.getJobDetail(post_NO);
        System.out.println("***Detail Controller..***");
        System.out.println("   Detail.num   : " + dto.getPOST_NO());
        return dto;
    }

}