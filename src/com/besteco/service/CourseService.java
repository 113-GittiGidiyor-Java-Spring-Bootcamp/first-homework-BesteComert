package com.besteco.service;

import com.besteco.models.Course;
import com.besteco.models.Instructor;
import com.besteco.models.Student;
import com.besteco.repository.CrudRepository;
import com.besteco.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course> {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Course> findAll() {
        List<Course> courses = em.createQuery("from Course", Course.class).getResultList();
        return courses;
    }

    @Override
    public Course findById(String id) {
        Course course = em.find(Course.class, id);
        return course;
    }

    @Override
    public void saveToDatabase(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public void updateDatabase(Course object) {

    }

    @Override
    public void deleteFromDatabase(String id) {
        em.getTransaction().begin();

        Course course=
                em.createQuery("from Customer c Where c.id=:id", Course.class).setParameter("id",id).getSingleResult();
        em.remove(course);

        em.getTransaction().commit();
    }

    public List<Student> findAllStudentsByCourse(String id){
        List<Student> students= findById(id).getStudentList();
        return students;
    }

    public Instructor findInstructorofTheCourse(String id){
        Instructor instructor = findById(id).getInstructor();
        return instructor;
    }
}
