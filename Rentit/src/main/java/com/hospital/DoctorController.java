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

//	@GetMapping("/test")
//	public String viewHome() {
//	    return "hello";
//	}
//	
	
}