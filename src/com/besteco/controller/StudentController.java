package com.besteco.controller;
import com.besteco.models.Course;
import com.besteco.models.Student;
import com.besteco.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public Student findStudent(String studentId){
        return studentService.findById(studentId);
    }

    public List<Student> findAllStudent(){
        return studentService.findAll();
    }

    public void saveStudent(Student student){
        studentService.saveToDatabase(student);
    }

    public void deleteStudent(String id){
        studentService.deleteFromDatabase(id);
    }

    public List<Course> findCoursesOfStudent(String id){
        return studentService.findCourses(id);
    }
}
