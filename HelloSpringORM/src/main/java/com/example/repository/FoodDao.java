package com.example.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Food;

/*
 * Spring ORM - is a Spring module that allows Spring to manage
 * an ORM framework in your place. In our case, we let Spring ORM
 * manage Hibernate.
 */

@Repository("foodRepo")
@Transactional
/*
 * tells Spring that the method or class creates transactions.
 * Spring will then create and manage your sessions and commits for you.
 */
public class FoodDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public FoodDao() {
	}
	
	public void insert(Food food) {
		sesFact.getCurrentSession().save(food);
	}
	
	public void update(Food food) {
		sesFact.getCurrentSession().update(food);
	}
	
	public Food selectById(Integer id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}
	
	public List<Food> selectAll(){
		return sesFact.getCurrentSession().createQuery("from Food", Food.class).list();
	}

}
