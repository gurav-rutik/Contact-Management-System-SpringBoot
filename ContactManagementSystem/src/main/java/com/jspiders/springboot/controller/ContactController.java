package com.jspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.entity.Contact;
import com.jspiders.springboot.service.ContactService;

@RestController
@RequestMapping(path = "api/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping
	protected Contact addContact(@RequestBody Contact contact) {
		return contactService.addContact(contact);
	}

	@GetMapping
	protected List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}

	@PutMapping("/{id}")
	protected Contact updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
		return contactService.updateContact(id, contact);
	}

	@DeleteMapping("/{id}")
	protected void deleteContact(@PathVariable Integer id) {
		contactService.deleteContact(id);
	}
	
	@GetMapping("/{mobileNumber}")
	protected List<Contact> findBymobileNumber(@PathVariable long mobileNumber) {
		return contactService.findBymobileNumber(mobileNumber);
	}
	
}
