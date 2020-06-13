package com.hospital;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




	@Entity
	@Table(name="doctor")
	public class Doctor {
		@Id
		private int id;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
		public String getAppointments() {
			return appointments;
		}
		public void setAppointments(String appointments) {
			this.appointments = appointments;
		}
		private String name;
		private String specialization;
		private String appointments;
	}

