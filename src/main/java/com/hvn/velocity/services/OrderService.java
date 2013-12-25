package com.hvn.velocity.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hvn.velocity.entities.CustomerOrder;
import com.hvn.velocity.repositories.OrderDao;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public Integer save(Integer customerId, double total) {
		BigDecimal amount = new BigDecimal(total);
		Date dateProcessed = new Date();
		Random random = new Random();
		int refNum = random.nextInt(999999999);
		return orderDao.save(customerId, amount, dateProcessed, refNum);
	}
	
	public CustomerOrder getById(Integer id) {
		return (CustomerOrder) orderDao.findById(id);
	}
	
}
