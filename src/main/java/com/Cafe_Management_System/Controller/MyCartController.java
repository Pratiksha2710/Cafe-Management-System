package com.Cafe_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Cafe_Management_System.Service.MyCartService;

@Controller 
public class MyCartController {
	@Autowired
	private MyCartService myCartService;
	
	@RequestMapping("/deleteMyCart/{id}")
	public String deleteMyCart(@PathVariable("id") int id) {
		myCartService.deleteById(id);
		return"redirect:/addtocart";
	}
}
