package com.bashkarsampath.dynamicscheduler.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bashkarsampath.dynamicscheduler.configurations.SwaggerDocumentation;
import com.bashkarsampath.dynamicscheduler.postgresql.entities.Job;
import com.bashkarsampath.dynamicscheduler.postgresql.pojo.JobPOJO;
import com.bashkarsampath.dynamicscheduler.postgresql.service.JobService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@SwaggerDocumentation
public class JobController {
	private static final ObjectMapper mapper = new ObjectMapper()
			.setDefaultPropertyInclusion(JsonInclude.Include.ALWAYS);
	@Autowired
	private final JobService jobService;

	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/job")
	public ResponseEntity<?> addJob(@RequestBody JobPOJO job2) throws JsonProcessingException {
		try {

			job2.setCreatedTimestamp(LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("EST")))
					.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss")));
			Job job = mapper.readValue(mapper.writeValueAsString(job2), Job.class);
			jobService.createJob(job);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/job2")
	public ResponseEntity<?> addJob2(@RequestBody JobPOJO job2) throws JsonProcessingException {
		try {

			return new ResponseEntity<>(mapper.writeValueAsString(job2), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}