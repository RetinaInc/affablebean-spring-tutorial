package com.hvn.velocity.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvn.velocity.domain.Product;

@Repository
public class ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> findByCategoryId(Byte id) {
		return sessionFactory.getCurrentSession().createQuery("from Product where category.id="+id).list();
	}
	
	public Product findById(Integer id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}
	
}
