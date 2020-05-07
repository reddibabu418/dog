package com.dog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dog.interfaces.DogRepository;
import com.dog.model.Dog;
@Controller
public class DogController {
	
	@Autowired
	DogRepository dogRepository;
	
	@GetMapping("/signup")
    public String showSignUpForm(Dog dog) {
        return "addDog";
    }
	
	 @PostMapping("/addDog")
	    public String addUser(@Valid Dog dog, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "addDog";
	        }
	         
	        dogRepository.save(dog);
	        model.addAttribute("dogs", dogRepository.findAll());
	        return "index";
	    }
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    Dog dog = dogRepository.findById(id);	     
	    model.addAttribute("dog", dog);
	    return "updateDog";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Dog dog, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        dog.setId(id);
	        return "updateDog";
	    }
	         
	    dogRepository.save(dog);
	    model.addAttribute("dogs", dogRepository.findAll());
	    return "index";
	}

}
