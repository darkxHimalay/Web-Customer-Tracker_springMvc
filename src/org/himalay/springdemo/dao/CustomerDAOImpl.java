package org.himalay.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.himalay.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomer() {
        Session currentSession=sessionFactory.getCurrentSession();
        Query<Customer> query=currentSession.createQuery("from Customer order by lastName",Customer.class);
        List<Customer> customerList=query.getResultList();
        return customerList;
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession=sessionFactory.getCurrentSession();
        Customer customer=currentSession.get(Customer.class,id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession=sessionFactory.getCurrentSession();
        Customer customer=currentSession.get(Customer.class,id);
        currentSession.delete(customer);
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession=sessionFactory.getCurrentSession();
        //***Save or Update code by Hibernate when we need changes in same field
        //currentSession.save(customer);
        currentSession.saveOrUpdate(customer);
    }
}