package com.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    
	    return "Home";
	}
	
	@RequestMapping("/loginpage")
	public ModelAndView viewLogin(@ModelAttribute("loginBean") LoginBean login) {
		User loginValid = service.authenticate(login.getUsername(), login.getPassword());
		
		if (loginValid != null) {
			String role = loginValid.getRole();
			ModelAndView modelAndView = new ModelAndView("Welcome");
		    modelAndView.addObject("role", role);
		    return modelAndView;
			
		} else {
			ModelAndView modelAndView = new ModelAndView("Home");
	        return modelAndView;
		}
		
	}
	
	@RequestMapping("/registrationpage")
	public String viewRegister(Model model) {
		User user = new User();
	    model.addAttribute("user", user);
	    return "register";
	}
	
	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public String saveRegisteredUser(@ModelAttribute("user") User user) {
	    service.saveRegisteredUser(user);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/patients")
	public String viewPatientsPage(Model model) {
	    List<Patient> listPatients = service.listAll();
	    model.addAttribute("listPatients", listPatients);
	     
	    return "patient";
	}
	
	@RequestMapping("/new")
	public String showNewPatientPage(Model model) {
		Patient patient = new Patient();
	    model.addAttribute("patient", patient);
	     
	    return "AddPatient";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("patient") Patient patient) {
	    service.save(patient);
	     
	    return "redirect:/patients";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("EditPatient");
	    Patient patient = service.get(id);
	    mav.addObject("patient", patient);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/patients";       
	}
	
//	@GetMapping("/test")
//	public String viewHome() {
//	    return "hello";
//	}
//	
	

}
