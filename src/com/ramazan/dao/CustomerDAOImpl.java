package com.ramazan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ramazan.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the session factroy
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName ", Customer.class);

		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = currentSession.get(Customer.class, customerId);

		return customer;

		// Query<Customer> theQuery = currentSession.createQuery("from Customer where id
		// = (:customerId)", Customer.class);
		//
		// theQuery.setParameter("customerId", customerId, StandardBasicTypes.INTEGER);
		// return theQuery.getSingleResult();

	}

	@Override
	public void deleteCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("delete from Customer where id = :customerId");

		theQuery.setParameter("customerId", customerId);
		theQuery.executeUpdate();

	}

}
