package com.mapping.MappingExample;

import com.mapping.MappingExample.Entity.Course;
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
//			deleteInstructor(appService);
//			findInstructorDetails(appService);
//			deleteInstructorDetails(appService);
			createInstructorWithCourses(appService);
		};
	}

	private void createInstructor(AppService appService) {

		Instructor instructor =
				new Instructor("Hash", "Hash", "hash@naveen.com");

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

		appService.deleteInstructor(5);

		System.out.println("Done....");
	}

	private void findInstructorDetails(AppService appService) {

		InstructorDetail instructorDetail = appService.findInstructorDetail(1);

		System.out.println("Instructor Detail "+instructorDetail);

		System.out.println("Instructor "+instructorDetail.getInstructor());

	}

	private void deleteInstructorDetails(AppService appService) {

		System.out.println("Deleting Instructor Detail....");

		appService.deleteInstructorDetail(5);

		System.out.println("Done....");
	}

	private void createInstructorWithCourses(AppService appService){

		Instructor instructor =
				new Instructor("Don", "Hawkin", "don@naveen.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("www.youtube.in", "Hahaha");

		System.out.println("Saving Instructor....");

		instructor.setInstructorDetail(instructorDetail);

		Course course = new Course("Language");

		Course course1 = new Course("Romance");

		Course course2 = new Course("Action");

		System.out.println("Saving Course....");

		instructor.addCourse(course);
		instructor.addCourse(course1);
		instructor.addCourse(course2);

		appService.save(instructor);

		System.out.println("Done....");

	}
}
