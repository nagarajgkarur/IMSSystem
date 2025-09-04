package com.iamsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamsystem.domain.Jobs;
import com.iamsystem.repository.JobsRepository;

@Service
public class JobsService {

	@Autowired
	JobsRepository jobsRepository;
	public Jobs createJob(Jobs job) {
		return jobsRepository.save(job);
	}

	public List<Jobs> getAllJobs(){
		return jobsRepository.findAll();
	}

	public List<Jobs> createBulkJobs(List<Jobs> jobs){
		List<Jobs> resultList = new ArrayList<>();
		jobs.stream().forEach( e->{
			resultList.add(jobsRepository.save(e));
		});
		return resultList;
	}

}
