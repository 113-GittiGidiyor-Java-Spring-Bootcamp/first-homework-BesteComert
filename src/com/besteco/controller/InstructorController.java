package com.besteco.controller;

import com.besteco.models.Instructor;
import com.besteco.models.Student;
import com.besteco.service.InstructorService;
import com.besteco.service.StudentService;

import java.util.List;

public class InstructorController {

    private InstructorService instructorService = new InstructorService();

    public Instructor findInstructor(String instructorId){
        return instructorService.findById(instructorId);
    }

    public List<Instructor> findAllInstructors(){
        return instructorService.findAll();
    }

    public void saveInstructor(Instructor instructor){
        instructorService.saveToDatabase(instructor);
    }

    public void deleteInstructor(String id){
        instructorService.deleteFromDatabase(id);
    }

    public List<Instructor> findCoursesOfInstructor(String id){
        return findCoursesOfInstructor(id);
    }
}
