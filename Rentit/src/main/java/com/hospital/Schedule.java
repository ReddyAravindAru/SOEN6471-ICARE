package com.hospital;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	
	@Entity
	@Table(name="schedule")
	public class Schedule {
		
		private Long id;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getShift_start() {
			return shift_start;
		}
		public void setShift_start(String shift_start) {
			this.shift_start = shift_start;
		}
		public String getShift_end() {
			return shift_end;
		}
		public void setShift_end(String shift_end) {
			this.shift_end = shift_end;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getAppointments() {
			return appointments;
		}
		public void setAppointments(String appointments) {
			this.appointments = appointments;
		}

		private String name;
		private String shift_start;
		private String shift_end;
		private String designation;
		private String appointments;
	}



