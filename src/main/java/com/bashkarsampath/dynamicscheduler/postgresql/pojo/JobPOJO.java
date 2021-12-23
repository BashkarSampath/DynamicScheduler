package com.bashkarsampath.dynamicscheduler.postgresql.pojo;

import com.bashkarsampath.dynamicscheduler.postgresql.entities.RequestBody;
import com.bashkarsampath.dynamicscheduler.postgresql.entities.RequestHttpHeaders;
import com.bashkarsampath.dynamicscheduler.postgresql.entities.RetryConfig;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobPOJO {
	private String userId;
	private String description;
	@JsonProperty("frequency_cron")
	private String frequencyCron;
	@JsonProperty("job_name")
	private String jobName;
	private String timezone;
	@JsonProperty("created_timestamp")
	private String createdTimestamp;
	@JsonProperty("modified_timestamp")
	private String modifiedTimestamp;
	private boolean completed;
	private boolean cancelled;
	@JsonProperty("cancellation_reason")
	private String cancellationReason;
	@JsonProperty("request_url_with_schema")
	public String requestUrl;
	@JsonProperty("request_http_method")
	public String requestHttpMethod;
	private RetryConfig retryConfig;
	@JsonProperty("request_http_headers")
	private RequestHttpHeaders requestHttpHeaders;
	@JsonProperty("request_body")
	private RequestBody requestBody;
}