package com.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	

	@RequestMapping("/doctors")
	public String viewListOfDoctors(Model model) {
	    List<Doctor> listDoctors = service.listAll();
	    model.addAttribute("listDoctors", listDoctors);
	     
	    return "doctor";
	}

	@RequestMapping("/doctor{id}")
	public String viewDoctorProfile(Model model)
	{
		Doctor doctor = service.getDoctorByID();
		return doctor;
	}

	
//	@GetMapping("/test")
//	public String viewHome() {
//	    return "hello";
//	}
//	
	
}