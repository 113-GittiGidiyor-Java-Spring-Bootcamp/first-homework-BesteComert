package com.besteco.service;

import com.besteco.models.Course;
import com.besteco.models.Instructor;
import com.besteco.repository.CrudRepository;
import com.besteco.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements CrudRepository<Instructor> {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Instructor> findAll() {

        List<Instructor> instructors = em.createQuery("select i from Instructor i", Instructor.class).getResultList();
        return instructors;
    }

    @Override
    public Instructor findById(String id) {

        Instructor instructor = em.find(Instructor.class, id);
        return instructor;
    }

    @Override
    public void saveToDatabase(Instructor instructor) {

        em.getTransaction().begin();

        em.persist(instructor);

        em.getTransaction().commit();
    }

    @Override
    public void updateDatabase(Instructor newInstructor) {

        em.getTransaction().begin();
        String id = newInstructor.getId();
        Instructor instructor=
                em.createQuery("from Instructor c Where c.id=:id", Instructor.class).setParameter("id",id).getSingleResult();
        em.remove(instructor);
        em.persist(newInstructor);

        em.getTransaction().commit();
    }

    @Override
    public void deleteFromDatabase(String id) {

        em.getTransaction().begin();

        Instructor instructor=
                em.createQuery("from Instructor c Where c.id=:id", Instructor.class).setParameter("id",id).getSingleResult();
        em.remove(instructor);

        em.getTransaction().commit();
    }

    public List<Course> findCourses(String id){
        List<Course> courses = findById(id).getCourseList();
        return courses;
    }
}
