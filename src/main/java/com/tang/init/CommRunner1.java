package com.tang.init;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CommRunner1 implements CommandLineRunner {
	private RepositoryService repositoryService;
	
	public CommRunner1(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	@Override
	public void run(String... args) throws Exception {
//		Deployment deployment = repositoryService.createDeployment()
//		        .addClasspathResource("processes/resume-process.bpmn20.xml").deploy();
//		System.out.println(deployment.getId());
	}

//	@Bean
//	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
//
//	    return new InitializingBean() {
//	        public void afterPropertiesSet() throws Exception {
//
//	            Group group = identityService.newGroup("user");
//	            group.setName("users");
//	            group.setType("security-role");
//	            identityService.saveGroup(group);
//
//	            User admin = identityService.newUser("admin");
//	            admin.setPassword("admin");
//	            identityService.saveUser(admin);
//
//	        }
//	    };
//	}
	
//	@Bean
//	public DataSource database() {
//	    return DataSourceBuilder.create()
//	        .url("jdbc:mysql://127.0.0.1:3306/activiti?characterEncoding=UTF-8")
//	        .username("root")
//	        .password("root")
//	        .driverClassName("com.mysql.jdbc.Driver")
//	        .build();
//	}
}
