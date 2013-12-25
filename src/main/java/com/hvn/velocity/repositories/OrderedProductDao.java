package com.hvn.velocity.repositories;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvn.velocity.entities.OrderedProduct;

@Repository
public class OrderedProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Set<OrderedProduct> orderedProducts) {
		Session session = sessionFactory.getCurrentSession();
		for (OrderedProduct orderedProduct : orderedProducts) {
			session.save(orderedProduct);
		}
	}
	
}
