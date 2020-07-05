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
import org.springframework.web.servlet.ModelAndView;




@Controller
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	@Autowired
	private ScheduleService scheduleService;
	

	@RequestMapping("/doctors")
	public String viewListOfDoctors(Model model) {
	    List<Doctor> listDoctors = service.listAll();
	    model.addAttribute("listDoctors", listDoctors);
	     
	    return "doctor";
	}
	@RequestMapping("/schedule")
	public String viewStaffSchedule(Model model) {
	    List<Schedule> listSchedule = scheduleService.listAll();
	    model.addAttribute("listSchedule", listSchedule);
	     
	    return "Schedules";
	}
	@RequestMapping("/newDoctor")
	public String showNewDoctorPage(Model model) {
	    Doctor doctor = new Doctor();
	    model.addAttribute("doctor", doctor);
	     
	    return "AddDoctor";
	}
	
	@RequestMapping("/newSchedule")
	public String showNewSchedulePage(Model model) {
		Schedule schedule = new Schedule();
	    model.addAttribute("schedule", schedule);
	     
	    return "AddSchedule";
	}
	
	
	@RequestMapping(value = "/saveDoctor", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
	    service.save(doctor);
	     
	    return "redirect:/doctors";
	}
	
	@RequestMapping(value = "/saveSchedule", method = RequestMethod.POST)
	public String saveSchedule(@ModelAttribute("schedule") Schedule schedule) {
		scheduleService.save(schedule);
	     
	    return "redirect:/schedule";
	}
	
	@RequestMapping("/editDoctor/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("EditDoctor");
	    Doctor doctor = service.get(id);
	    mav.addObject("doctor", doctor);
	     
	    return mav;
	}
	
	@RequestMapping("/editSchedule/{id}")
	public ModelAndView showEditSchedule(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("EditSchedule");
	    Schedule schedule = scheduleService.get(id);
	    mav.addObject("schedule", schedule);
	     
	    return mav;
	}
	@RequestMapping("/deleteDoctor/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/doctors";       
	}
	
	@RequestMapping("/deleteSchedule/{id}")
	public String deleteSchedule(@PathVariable(name = "id") int id) {
		scheduleService.delete(id);
	    return "redirect:/schedule";       
	}
	
	
//	@GetMapping("/test")
//	public String viewHome() {
//	    return "hello";
//	}
	
	
}