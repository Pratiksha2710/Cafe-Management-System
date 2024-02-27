package com.Cafe_Management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Cafe_Management_System.Model.Cafe;
import com.Cafe_Management_System.Model.ContactForm;
import com.Cafe_Management_System.Model.MyCart;
import com.Cafe_Management_System.Service.CafeService;
import com.Cafe_Management_System.Service.ContactService;
import com.Cafe_Management_System.Service.MyCartService;

@Controller
public class CafeController {
	@Autowired
	private CafeService cafeservice;
	
	@Autowired
	private MyCartService myCartService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	@GetMapping("/add-item")
    public String addItems() {
        return "additem";
    }
	
	 @GetMapping("/cart")
	    public ModelAndView getAllItems() {
		    List<Cafe> list = cafeservice.getAllItems();
	        ModelAndView m= new ModelAndView();
	        m.setViewName("cart");
	        m.addObject("item",list);
	        return m;
	    }
	 @PostMapping("/save")
	 public String addItemcafe(@ModelAttribute Cafe cafe) {
		 cafeservice.save(cafe);
		 return "redirect:/cart";
	 }
	 @GetMapping("/addtocart")
	 public String getMyCarts(Model model) {
		 List<MyCart>list = myCartService.getAllMyItems();
		 model.addAttribute("item", list);
		 return "addtocart";
	 }
	 @RequestMapping("/myitem/{id}")
	 public String getMyItem(@PathVariable("id") int id) {
		 Cafe cafe = cafeservice.getItemById(id);
		 MyCart mc = new MyCart(cafe.getId(), cafe.getName(), cafe.getPrice());
		 myCartService.saveMyCarts(mc);
		 return "redirect:/addtocart";
	 }
	 @RequestMapping("/editItem/{id}")
		public String editItem(@PathVariable("id") int id, Model model) {
		 Cafe cafe = cafeservice.getItemById(id);
		 model.addAttribute("cafe", cafe);	
			return "itemEdit";
		}
	 @RequestMapping("/deleteItem/{id}")
	 public String deleteItem(@PathVariable("id")int id) {
		 cafeservice.deleteById(id);
		 return "redirect:/cart";
	 }
	 
	 @PostMapping("/submitContactForm")
	    public String submitContactForm(@ModelAttribute ContactForm contactForm , Model model) {
	        ContactForm contactFormData = new ContactForm();
	        contactFormData.setName(contactForm.getName());
	        contactFormData.setEmail(contactForm.getEmail());
	        contactFormData.setMessage(contactForm.getMessage());
	        contactService.save(contactForm);
	        return "home";
	 }        
	
}