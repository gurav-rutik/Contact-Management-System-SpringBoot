package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.entity.Contact;
import com.jspiders.springboot.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
		
	}

	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
		
	}

	public Contact updateContact(Integer id, Contact updatedContact) {
		Optional<Contact> optionalContact = contactRepository.findById(id);
		
		if(optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			
			contact.setFirstName(updatedContact.getFirstName());
			contact.setLastName(updatedContact.getLastName());
			contact.setMobileNumber(updatedContact.getMobileNumber());
			contact.setWorkNumber(updatedContact.getWorkNumber());
			contact.setEmail(updatedContact.getEmail());
			
			return contactRepository.save(contact);
		}else {
			throw new RuntimeException("Contact not found!");
		}
		
	}

	public void deleteContact(Integer id) {
		contactRepository.deleteById(id);
		
	}

	public List<Contact> findBymobileNumber(long mobileNumber) {
		return contactRepository.findBymobileNumber(mobileNumber);
		
	}
}
