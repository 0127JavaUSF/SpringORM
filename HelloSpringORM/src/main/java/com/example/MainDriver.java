package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Food;
import com.example.repository.FoodDao;

public class MainDriver {

	
	public static ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("ApplicationContext.xml");
	public static FoodDao foodDao = appContext.getBean("foodRepo", FoodDao.class);
	
	public static void main(String[] args) {
		System.out.println("start");
		insertInitialValues();
		System.out.println("All our foods: " + foodDao.selectAll());
	}
	
	public static void insertInitialValues() {
		Food food1 = new Food(0, "Arepas", true);
		foodDao.insert(food1);
		
		Food food2 = new Food(0, "Tacos", false);
		foodDao.insert(food2);
		
		Food food3 = new Food(0, "Pancakes", true);
		foodDao.insert(food3);
		
	}

}
