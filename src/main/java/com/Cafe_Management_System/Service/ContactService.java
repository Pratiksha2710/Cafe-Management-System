package com.Cafe_Management_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cafe_Management_System.Model.ContactForm;
import com.Cafe_Management_System.Repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository CRepo;
	
	public void save(ContactForm cf) {
		// TODO Auto-generated method stub
		CRepo.save(cf);
}

}
