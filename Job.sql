CREATE TABLE 
    job 
    ( 
        id UUID NOT NULL, 
        user_id TEXT NOT NULL, 
        http_request_id UUID NOT NULL, 
        retry_config JSONB, 
        description         TEXT NOT NULL, 
        frequency_cron      TEXT NOT NULL, 
        job_name            TEXT NOT NULL, 
        timezone            TIMESTAMP(6) WITH TIME ZONE NOT NULL, 
        created_timestamp   TIMESTAMP(6) WITH TIME ZONE NOT NULL, 
        modified_timestamp  TIMESTAMP(6) WITH TIME ZONE NOT NULL, 
        completed           BOOLEAN NOT NULL, 
        cancelled           BOOLEAN NOT NULL, 
        cancellation_reason TEXT, 
        CONSTRAINT newtable_pkey PRIMARY KEY (id), 
        CONSTRAINT job_fk1 FOREIGN KEY (http_request_id) REFERENCES "http_request" ("id"), 
        UNIQUE (http_request_id) 
    );

CREATE TABLE 
    http_request 
    ( 
        id UUID NOT NULL, 
        request_method          TEXT NOT NULL, 
        request_url_with_schema TEXT NOT NULL, 
        request_http_headers JSONB NOT NULL, 
        request_body JSONB, 
        PRIMARY KEY (id) 
    );