package com.Cafe_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cafe_Management_System.Model.Cafe;
import com.Cafe_Management_System.Repository.CafeRepository;

@Service
public class CafeService {
	@Autowired
	private CafeRepository cafeRepository;
	
	public void save(Cafe cafe) {
		cafeRepository.save(cafe);
	}
	public List<Cafe> getAllItems(){
		return cafeRepository.findAll();
	}
	public Cafe getItemById(int id) {
		return cafeRepository.findById(id).get();
	}
	public void deleteById( int id) {
		cafeRepository.deleteById(id);
	}
	
}
