package com.example.registrationapi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository <User, Long> {
	java.util.List<User> findAll();
	
}