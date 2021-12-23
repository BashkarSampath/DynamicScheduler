package com.bashkarsampath.dynamicscheduler.postgresql.service;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bashkarsampath.dynamicscheduler.postgresql.dao.JobDAO;
import com.bashkarsampath.dynamicscheduler.postgresql.entities.Job;

@Service
public class SimpleJobService implements JobService {

	private final JobDAO jobDAO;

	@Autowired
	public SimpleJobService(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void createJob(@NotNull Job job) {
		Objects.requireNonNull(job);
		jobDAO.save(job);
	}

}
