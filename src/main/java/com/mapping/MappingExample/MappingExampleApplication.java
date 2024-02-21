package com.mapping.MappingExample;

import com.mapping.MappingExample.Entity.Course;
import com.mapping.MappingExample.Entity.Instructor;
import com.mapping.MappingExample.Entity.InstructorDetail;
import com.mapping.MappingExample.Entity.Review;
import com.mapping.MappingExample.Service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@SpringBootApplication
public class MappingExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppService appService) {
        return runner -> {
//			createInstructor(appService);
//			findInstructor(appService);
//			deleteInstructor(appService);
//			findInstructorDetails(appService);
//			deleteInstructorDetails(appService);
//			createInstructorWithCourses(appService);
//			findInstructorAndCourses(appService);
//			findInstructorJoinFetchCourses(appService);
//			updateInstructor(appService);
//			deleteInstructorById(appService);
//          saveCourses(appService);
            findCourseAndReview(appService);

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

        System.out.println("Instructor Detail " + instructorDetail);

        System.out.println("Instructor " + instructorDetail.getInstructor());

    }

    private void deleteInstructorDetails(AppService appService) {

        System.out.println("Deleting Instructor Detail....");

        appService.deleteInstructorDetail(5);

        System.out.println("Done....");
    }

    private void createInstructorWithCourses(AppService appService) {

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

    private void findInstructorAndCourses(AppService appService) {

        Instructor instructor = appService.findInstructor(6);

        System.out.println("Instructor Details");

        System.out.println(instructor);

        List<Course> courseList = appService.findCourseByInstructorId(6);

        instructor.setCourses(courseList);

        System.out.println("Get Courses");

        System.out.println(instructor.getCourses());

    }

    private void findInstructorJoinFetchCourses(AppService appService) {
        Instructor instructor = appService.findInstructorByIdJoinFetch(6);
        System.out.println("Instructor Details");
        System.out.println(instructor);
        System.out.println("Get Courses");
        System.out.println(instructor.getCourses());
    }

    private void updateInstructor(AppService appService) {

        Instructor instructor = appService.findInstructor(6);

        instructor.setFirstName("Happy");

        System.out.println("Updatation");

        appService.updateInstructor(instructor);

        System.out.println("Done");

    }

    public void deleteInstructorById(AppService appService) {

        System.out.println("Deleting");
        appService.deleteInstructorById(6);
        System.out.println("Done");


    }

    public void saveCourses(AppService appService) {
        System.out.println("Course is Saving");

        Course course = new Course("World Of Love");

        course.addReview(new Review("Great Course"));
        course.addReview(new Review("Loved It"));

		appService.saveCourse(course);

		System.out.println("Done");
    }

    public void findCourseAndReview(AppService appService) {
        Course course = appService.findCourseAndReview(4);

        System.out.println("Course :"+ course);
        System.out.println("Review List :"+ course.getReviews());
    }

}
