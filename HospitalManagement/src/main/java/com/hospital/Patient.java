package com.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	
	@Entity
	//@Table(name="patient")
	public class Patient {
	
		private Long id;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		private String name;
		
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getSickness() {
			return sickness;
		}

		public void setSickness(String sickness) {
			this.sickness = sickness;
		}

		public String getMedical_history() {
			return medical_history;
		}

		public void setMedical_history(String medical_history) {
			this.medical_history = medical_history;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		private String city;
		private String sickness;
		private String medical_history;
		private String country;
		private int age;
		
	

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	
		@Override
		public String toString(){
			return "id="+id+", name="+name;
		}
	
}
