package com.bashkarsampath.dynamicscheduler.postgresql.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bashkarsampath.dynamicscheduler.postgresql.entities.Job;

public interface JobDAO extends CrudRepository<Job, UUID> {
}