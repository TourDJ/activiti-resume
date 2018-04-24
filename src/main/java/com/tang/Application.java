package com.tang;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tang.init.ActivitiRunner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new ActivitiRunner(repositoryService, runtimeService, taskService);
//		return new CommandLineRunner() {
//
//	        public void run(String... strings) throws Exception {
//	            Map<String, Object> variables = new HashMap<String, Object>();
//	            variables.put("applicantName", "John Doe");
//	            variables.put("email", "john.doe@activiti.com");
//	            variables.put("phoneNumber", "123456789");
//	            runtimeService.startProcessInstanceByKey("hireProcess", variables);
//	        }
//	    };
    }
	
//	@Bean
//	public DataSource database() {
//	    return DataSourceBuilder.create()
//	        .url("jdbc:mysql://127.0.0.1:3306/activiti?characterEncoding=UTF-8")
//	        .username("root")
//	        .password("root")
//	        .driverClassName("com.mysql.jdbc.Driver")
//	        .build();
//	}
	
	@Bean
	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

		return new InitializingBean() {
			public void afterPropertiesSet() throws Exception {

				Group group = identityService.newGroup("user");
				group.setName("users");
				group.setType("security-role");
				identityService.saveGroup(group);

				User admin = identityService.newUser("admin");
				admin.setPassword("admin");
				admin.setFirstName("John");
				admin.setLastName("Doe");
				identityService.saveUser(admin);
				
				User admin2 = identityService.newUser("admin2");
				admin2.setPassword("admin2");
				identityService.saveUser(admin2);

			}
		};
	}
}
