package com.ty.HospitalManagementSystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.HospitalDao;
import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.savehospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		Hospital dbhospital = dao.updatHospital(id, hospital);
		if (dbhospital != null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Successfully Updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbhospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital hospital = dao.deleteHospital(id);
		if (hospital != null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for given hospital id");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyid(int id) {
		Hospital hospital = dao.getHospitalbyid(id);
		if (hospital != null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Successfully Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("no id found");
		}
	}

	public Hospital getHospitalbyemail(String email) {
		Hospital hospital = dao.gethospitalbyemail(email);
		if (hospital != null) {
			return hospital;
		} else {
			return null;
		}
	}
}
