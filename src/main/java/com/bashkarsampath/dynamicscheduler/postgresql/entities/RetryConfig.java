package com.bashkarsampath.dynamicscheduler.postgresql.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetryConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	private long max_backoff_duration_ms;
	private int max_doublings;
	private int max_retry_attempts;
	private long max_retry_duration_ms;
	private long min_backoff_duration_ms;
}
