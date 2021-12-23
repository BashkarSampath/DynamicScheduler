package com.bashkarsampath.dynamicscheduler.taskscheduler;

import lombok.Data;

@Data
public class TaskDefinition {
    private String cronExpression;
    private String actionType;
    private String data;
}