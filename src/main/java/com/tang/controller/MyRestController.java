package com.tang.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tang.service.MyService;

@RestController
public class MyRestController {

	@Autowired
	private  MyService myService;
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public void startProcessInstance() {
		myService.startProcess();
	}
	
	@RequestMapping(value="/tasks", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
		List<Task> tasks = myService.geTasks(assignee);
		List<TaskRepresentation> dtos = new ArrayList<>();
		for (Task task : tasks) {
			dtos.add(new TaskRepresentation(task.getId(), task.getName()));
		}
		
		return dtos;
	}
	
	
	static class TaskRepresentation { 

        private String id;
        private String name;

        public TaskRepresentation(String id, String name) {
            this.id = id;
            this.name = name;
        }

         public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }
}
