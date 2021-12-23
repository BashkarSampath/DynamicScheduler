package com.bashkarsampath.dynamicscheduler.postgresql.service;

import javax.validation.constraints.NotNull;

import com.bashkarsampath.dynamicscheduler.postgresql.entities.Job;

public interface JobService {
	void createJob(@NotNull Job job);
}
