package com.bashkarsampath.dynamicscheduler.postgresql.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Job", schema = "dev")
public class Job extends EntityWithUUID {
	@NotNull
	@Column(name = "user_id")
	private String userId;

	@NotNull
	@Column(name = "description")
	private String description;

	@NotNull
	@JsonProperty("frequency_cron")
	@Column(name = "frequency_cron")
	private String frequencyCron;

	@NotNull
	@JsonProperty("job_name")
	@Column(name = "job_name")
	private String jobName;

	@NotNull
	@Column(name = "timezone")
	private String timezone;

	@NotNull
	@JsonProperty("created_timestamp")
	@Column(name = "created_timestamp")
	private String createdTimestamp;

	@JsonProperty("modified_timestamp")
	@Column(name = "modified_timestamp")
	private String modifiedTimestamp;

	@NotNull
	@Column(name = "completed")
	private boolean completed;

	@NotNull
	@Column(name = "cancelled")
	private boolean cancelled;

	@JsonProperty("cancellation_reason")
	@Column(name = "cancellation_reason")
	private String cancellationReason;

	@NotNull
	@JsonProperty("request_url_with_schema")
	@Column(name = "request_url_with_schema")
	@Nationalized
	public String requestUrl;

	@NotNull
	@JsonProperty("request_http_method")
	@Column(name = "request_http_method")
	@Nationalized
	public String requestHttpMethod;

	@NotNull
	@Type(type = "jsonb")
	@Column(name = "retry_config", columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private RetryConfig retryConfig;

	@NotNull
	@Type(type = "jsonb")
	@JsonProperty("request_http_headers")
	@Column(name = "request_http_headers", columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private RequestHttpHeaders requestHttpHeaders;

	@NotNull
	@Type(type = "jsonb")
	@JsonProperty("request_body")
	@Column(name = "request_body", columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private RequestBody requestBody;
}
