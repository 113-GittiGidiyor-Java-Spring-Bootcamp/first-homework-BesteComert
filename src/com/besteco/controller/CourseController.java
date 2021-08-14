package com.besteco.controller;

import com.besteco.models.Course;
import com.besteco.models.Instructor;
import com.besteco.models.Student;
import com.besteco.service.CourseService;

import javax.persistence.Entity;
import java.util.List;

public class CourseController {

    private CourseService courseService = new CourseService();

    public Course findCustomer(String customerId){
        return courseService.findById(customerId);
    }

    public List<Course> findAllCourse(){
        return courseService.findAll();
    }

    public void saveCourse(Course course){
        courseService.saveToDatabase(course);
    }

    public void deleteCourse(String id){
        courseService.deleteFromDatabase(id);
    }

    public List<Student> findStudentsOfCourse(String id){
        return courseService.findAllStudentsByCourse(id);
    }

    public Instructor findInstructorOfCourse(String id){ return findInstructorOfCourse(id);}
}
