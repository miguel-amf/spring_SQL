package com.example.sqldemo.dao;

import com.example.sqldemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;
    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        //return query results

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String queryLastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                            "FROM Student WHERE lastName=:theData", Student.class);
        //set query parameters
        theQuery.setParameter("theData", queryLastName);
        //return query results
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student toDelete = entityManager.find(Student.class, id);
        if (toDelete!=null) {
            entityManager.remove(toDelete);
        }
    }
}
