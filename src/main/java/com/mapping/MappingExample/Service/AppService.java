package com.mapping.MappingExample.Service;

import com.mapping.MappingExample.Entity.Course;
import com.mapping.MappingExample.Entity.Instructor;
import com.mapping.MappingExample.Entity.InstructorDetail;

import java.util.List;

public interface AppService {

    void save(Instructor instructor);
    Instructor findInstructor(int id);
    void deleteInstructor(int id);
    InstructorDetail findInstructorDetail(int id);
    void deleteInstructorDetail(int id);
    List<Course> findCourseByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateInstructor(Instructor instructor);
    void deleteInstructorById(int id);
    void saveCourse(Course course);
    Course findCourseAndReview(int id);
}
