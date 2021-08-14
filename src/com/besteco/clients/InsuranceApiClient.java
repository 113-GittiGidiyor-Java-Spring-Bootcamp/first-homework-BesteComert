package com.besteco.clients;

import com.besteco.models.Course;
import com.besteco.models.Instructor;
import com.besteco.models.Student;
import com.besteco.models.enums.Gender;
import com.besteco.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class InsuranceApiClient {

    public static void main(String[] args) {

        saveTestData(); 
    }

    private static void saveTestData(){

        Instructor instructor1 = new Instructor("Ömer Kahveci", "05516528787","omergokgoz@gmail.com");
        Instructor instructor2 = new Instructor("Aybüke Coşkun", "05576519805","aybukecoskun@gmail.com");
        Instructor instructor3 = new Instructor("Sare Keser", "05467284615","sarekeser@gmail.com");

        Course course1 = new Course("Calculus-1", 1101, 5);
        Course course2 = new Course("Calculus-2", 1102, 5);
        Course course3 = new Course("Physics-1", 2101, 4);
        Course course4 = new Course("Physics-2", 2102, 4);
        Course course5 = new Course("Chemistry-1", 3101, 5);
        Course course6 = new Course("Chemistry-2", 3104, 5);

        Student student1 = new Student("Tuna Savran", LocalDate.of(1996, Month.JANUARY,13),"Ankara", Gender.FEMALE);
        Student student2 = new Student("Sertel Kolat", LocalDate.of(1998, Month.JULY,18),"İstanbul", Gender.MALE);
        Student student3 = new Student("Ata Ozyilmaz", LocalDate.of(1997, Month.SEPTEMBER,6),"Bursa", Gender.MALE);

        instructor1.setCourseList(new ArrayList<>(Arrays.asList(course1,course3)));
        instructor2.setCourseList(new ArrayList<>(Arrays.asList(course2,course4)));
        instructor3.setCourseList(new ArrayList<>(Arrays.asList(course6,course5)));

        student1.setCourseList((new ArrayList<>(Arrays.asList(course1,course6))));
        student2.setCourseList((new ArrayList<>(Arrays.asList(course2,course5))));
        student3.setCourseList((new ArrayList<>(Arrays.asList(course3,course4))));

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try{
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);
            em.persist(course5);
            em.persist(course6);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);

        }catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
