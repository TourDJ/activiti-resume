package com.tang.service;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

	@Autowired(required=false)
	private RuntimeService runtimeService;
	
	@Autowired(required=false)
	private TaskService taskService;
	
	@Transactional
	public void startProcess() {
		runtimeService.startProcessInstanceByKey("oneTaskProcess");
	}
	
	@Transactional
	public List<Task> geTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}
}
