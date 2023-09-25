package com.ty.HospitalManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "name cannot be blank")
	private String name;
	@NotNull(message = "phone cannot be null or blank")
	@Min(value = 6000000000l)
	@Min(value = 9000000000l)
	private long phone;
	@NotBlank(message = "manager cannot be blank or null")
	private String manager;

	@ManyToOne
	private Hospital hospital;

	@OneToOne
	private Address address;

}
