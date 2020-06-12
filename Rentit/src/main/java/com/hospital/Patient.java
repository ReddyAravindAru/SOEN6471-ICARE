package com.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	
	@Entity
	@Table(name="patient")
	public class Patient {
		@Id
		private int id;
		
		private String name;
		
		

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
	
		@Override
		public String toString(){
			return "id="+id+", name="+name;
		}
	
}
