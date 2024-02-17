package com.mapping.MappingExample.Service;

import com.mapping.MappingExample.Entity.Instructor;
import com.mapping.MappingExample.Entity.InstructorDetail;

public interface AppService {

    void save(Instructor instructor);
    Instructor findInstructor(int id);
    void deleteInstructor(int id);
    InstructorDetail findInstructorDetail(int id);
    void deleteInstructorDetail(int id);

}
