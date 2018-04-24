package com.tang.init;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
/**
 * 
 * @author tang
 *
 */
public class ActivitiRunner implements CommandLineRunner {

	private final RepositoryService repositoryService;
	private final RuntimeService runtimeService;
	private final TaskService taskService;

	public ActivitiRunner(RepositoryService repositoryService, RuntimeService runtimeService, TaskService taskService) {
		this.repositoryService = repositoryService;
		this.runtimeService = runtimeService;
		this.taskService = taskService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
		System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
		Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("applicantName", "John Doe");
        variables.put("email", "john.doe@activiti.com");
        variables.put("phoneNumber", "123456789");
        runtimeService.startProcessInstanceByKey("hireProcess", variables);
		System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
	}

}
