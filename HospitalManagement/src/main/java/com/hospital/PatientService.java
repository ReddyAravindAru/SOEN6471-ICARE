package com.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientService {

	@Autowired
	private PatientRepository repo;

	@Autowired
	private LoginRepository loginRepo;

	public List<Patient> listAll() {
		return repo.findAll();
	}

	public void save(Patient patient) {
		repo.save(patient);
	}

	public Patient get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

	public User authenticate(String username, String password) {
		User login = loginRepo.findByUsernameAndPasswordIgnoreCase(username, password);
		return login;
	}
	
	public void saveRegisteredUser(User user) {
		loginRepo.save(user);
	}

}
