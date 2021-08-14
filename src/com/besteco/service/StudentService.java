package com.besteco.service;

import com.besteco.models.Course;
import com.besteco.models.Student;
import com.besteco.repository.CrudRepository;
import com.besteco.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        List<Student> studentList = em.createQuery("select i from Student i", Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student findById(String id) {

        Student student = em.find(Student.class, id);
        return student;
    }

    @Override
    public void saveToDatabase(Student student) {
        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();
    }

    @Override
    public void updateDatabase(Student newStudent) {
        em.getTransaction().begin();
        String id = newStudent.getId();
        Student student=
                em.createQuery("from Student c Where c.id=:id", Student.class).setParameter("id",id).getSingleResult();
        em.remove(student);
        em.persist(newStudent);

        em.getTransaction().commit();
    }

    @Override
    public void deleteFromDatabase(String id) {
        em.getTransaction().begin();

        Student student=
                em.createQuery("from Student c Where c.id=:id", Student.class).setParameter("id",id).getSingleResult();
        em.remove(student);

        em.getTransaction().commit();
    }

    public List<Course> findCourses(String id){
        List<Course> courses = findById(id).getCourseList();
        return courses;
    }
}
