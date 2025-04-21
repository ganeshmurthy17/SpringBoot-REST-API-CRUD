package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO
{
    // Define Field
    private EntityManager entityManager;

    //Define Constructor
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id)
    {
        Employee empid = entityManager.find(Employee.class, id);
        return empid;
    }

    @Override
    public Employee save(Employee theEmployee)
    {
        Employee merge = entityManager.merge(theEmployee);
        return merge;
    }

    @Override
    public void deleteById(int id) {
        Employee del = entityManager.find(Employee.class, id);
        entityManager.remove(del);
    }
}
