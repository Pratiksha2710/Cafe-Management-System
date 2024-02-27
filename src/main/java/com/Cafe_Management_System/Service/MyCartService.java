package com.Cafe_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cafe_Management_System.Model.MyCart;
import com.Cafe_Management_System.Repository.MyCartRepository;

@Service
public class MyCartService {
	@Autowired
	private MyCartRepository myCartRepository;
	public void saveMyCarts(MyCart carts) {
		 myCartRepository.save(carts);
	}
	public List<MyCart> getAllMyItems(){
		return myCartRepository.findAll();
	}
	public void deleteById(int id) {
		myCartRepository.deleteById(id);
	}
	
}
