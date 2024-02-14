package com.mapping.MappingExample;

import com.mapping.MappingExample.Entity.Instructor;
import com.mapping.MappingExample.Entity.InstructorDetail;
import com.mapping.MappingExample.Service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppService appService){
		return runner -> {
//			createInstructor(appService);
//			findInstructor(appService);
			deleteInstructor(appService);
		};
	}

	private void createInstructor(AppService appService) {

		Instructor instructor =
				new Instructor("Sana", "Hash", "hash@naveen.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("www.google.com", "focus on career");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving Instructor....");

		appService.save(instructor);

		System.out.println("Done....");

	}

	private void findInstructor(AppService appService) {

		Instructor instructor = appService.findInstructor(1);

		System.out.println(instructor);

	}

	private void deleteInstructor(AppService appService) {

		System.out.println("Deleting Instructor....");

		appService.deleteInstructor(3);

		System.out.println("Done....");
	}
}
