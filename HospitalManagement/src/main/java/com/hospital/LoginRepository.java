package com.hospital;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPasswordIgnoreCase (String username, String password);
	
}
