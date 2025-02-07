package com.jspiders.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	Optional<Contact> findById(Integer id);
	
	void deleteById(Integer id);

	List<Contact> findBymobileNumber(long mobileNumber);
}
