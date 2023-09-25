package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.MedItemsDao;
import com.ty.HospitalManagementSystem.dto.MedItems;

@Service
public class MedItemsService {

	@Autowired
	private MedItemsDao medItemsDao;

	public MedItems saveMedItems(int mid, MedItems medItems) {
		return medItemsDao.saveMedItems(medItems, mid);
	}

	public MedItems updateMedItems(int id, MedItems medItems) {
		MedItems medItems2 = medItemsDao.getMedItemsbyid(id);
		medItems.setMedorder(medItems2.getMedorder());
		MedItems daoMedItems = medItemsDao.updateMedItems(id, medItems);
		if (daoMedItems != null) {
			return daoMedItems;
		} else {
			return null;
		}
	}

	public MedItems deleteMedItems(int id) {
		MedItems medItems = medItemsDao.deleteMedItems(id);
		if (medItems != null) {
			return medItems;
		} else {
			return null;
		}
	}

	public MedItems getMedItemsbyid(int id) {
		MedItems medItems = medItemsDao.getMedItemsbyid(id);
		if (medItems != null) {
			return medItems;
		} else {
			return null;
		}
	}
}
