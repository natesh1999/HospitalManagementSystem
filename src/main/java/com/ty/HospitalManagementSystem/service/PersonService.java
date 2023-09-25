package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.PersonDao;
import com.ty.HospitalManagementSystem.dto.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public Person savePerson(Person person) {
		return personDao.savePerson(person);
	}

	public Person updatePerson(int id, Person person) {
		Person dbPerson = personDao.updatePerson(id, person);
		if (dbPerson != null) {
			return dbPerson;
		} else {
			return null;
		}
	}

	public Person deletePerson(int id) {
		Person person = personDao.deletePerson(id);
		if (person != null) {
			return person;
		} else {
			return null;
		}
	}

	public Person getpersonbyid(int id) {
		Person person = personDao.getpersonbyid(id);
		if (person != null) {
			return person;
		} else {
			return null;
		}
	}
}
