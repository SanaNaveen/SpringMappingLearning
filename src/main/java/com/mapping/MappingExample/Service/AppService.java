package com.mapping.MappingExample.Service;

import com.mapping.MappingExample.Entity.Instructor;

public interface AppService {

    void save(Instructor instructor);
    Instructor findInstructor(int id);
    void deleteInstructor(int id);

}
