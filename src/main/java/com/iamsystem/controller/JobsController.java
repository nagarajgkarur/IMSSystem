package com.iamsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.domain.Jobs;
import com.iamsystem.service.JobsService;

@RestController
@RequestMapping("/jobs")
public class JobsController {

	@Autowired
	JobsService jobsService;

	@PostMapping("/")
	public Jobs createJobs(@RequestBody Jobs job) {
		return jobsService.createJob(job);
	}

	@GetMapping("/")
	public List<Jobs> getJobs(){
		return jobsService.getAllJobs();
	}

	public List<Jobs> createBulkJobs(@RequestBody List<Jobs> jobs){
		return jobsService.createBulkJobs(jobs);
	}
}
