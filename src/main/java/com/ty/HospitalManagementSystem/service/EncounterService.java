package com.ty.HospitalManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.BranchDao;
import com.ty.HospitalManagementSystem.dao.EncounterDao;
import com.ty.HospitalManagementSystem.dao.PersonDao;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.dto.Encounter;
import com.ty.HospitalManagementSystem.dto.Person;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterdao;

	@Autowired
	private PersonDao persondao;

	@Autowired
	private BranchDao branchdao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = persondao.getpersonbyid(pid);
		Branch branch = branchdao.getBranchbyid(bid);

		encounter.setPerson(person);
		List<Branch> list = new ArrayList<>();
		list.add(branch);
		encounter.setList(list);

		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterdao.saveEncounter(encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Encounter>> updatEncounter(int id, Encounter encounter, int bid) {
		Encounter dbencounter = encounterdao.getencounterbyid(id);
		Branch branch = branchdao.getBranchbyid(bid);

		List<Branch> branchs = dbencounter.getList();
		encounter.setList(branchs);
		encounter.setPerson(dbencounter.getPerson());
		if (dbencounter!=null) {
			
		
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterdao.updatEncounter(bid, encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for encounter");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		Encounter encounter = encounterdao.deleteEncounter(id);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);

		} else {
			return null;
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> getencounterbyid(int id) {
		Encounter encounter = encounterdao.getencounterbyid(id);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure= new ResponseStructure<>();
			responseStructure.setMessage("Successfully updates");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		} else {
			return null;
		}

	}
}