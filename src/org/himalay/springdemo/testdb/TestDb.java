package org.himalay.springdemo.testdb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.himalay.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestDb {

    @Autowired
    private SessionFactory sessionFactory;

    Customer customer=new Customer();

    public static void main(String[] args) {
        try {
            System.out.println(new TestDb().getName(2));
        }catch (Exception e){e.printStackTrace();}
    }

    @Transactional
    public String getName(int n){
        Session session=sessionFactory.openSession();
        try {
            customer=session.get(Customer.class,n);
        }catch (Exception e){e.printStackTrace();}
        return customer.toString();
    }
}