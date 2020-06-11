package com.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Patient> listPatients = service.listAll();
	    model.addAttribute("listPatients", listPatients);
	     
	    return "patient";
	}

}
