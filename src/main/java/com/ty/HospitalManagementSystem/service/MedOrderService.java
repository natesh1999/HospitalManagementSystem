package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.MedorderDao;
import com.ty.HospitalManagementSystem.dto.Medorder;

@Service
public class MedOrderService {

	@Autowired
	private MedorderDao medorderDao;

	public Medorder saveMedorder(int eid, Medorder medorder) {
		return medorderDao.saveMedorder(medorder, eid);
	}

	public Medorder updateMedorder(int id, Medorder medorder) {
		Medorder dbMedorder = medorderDao.getmedorderbyid(id);
		medorder.setEncounter(dbMedorder.getEncounter());
		Medorder daoMedorder = medorderDao.updateMedorder(id, dbMedorder);
		if (daoMedorder != null) {
			return daoMedorder;
		} else {
			return null;
		}
	}

	public Medorder deleteMedorder(int id) {
		Medorder medorder = medorderDao.deleteMedorder(id);
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}

	public Medorder getMedorderbyid(int id) {
		Medorder medorder = medorderDao.getmedorderbyid(id);
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}
}
