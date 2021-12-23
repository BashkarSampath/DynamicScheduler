package com.bashkarsampath.dynamicscheduler.postgresql.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestHttpHeaders implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Map<String, Object> headers = new HashMap<>();

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.headers;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.headers.put(name, value);
	}
}
