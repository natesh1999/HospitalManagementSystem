package com.ty.HospitalManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Address;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepo branchRepo;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(int hid, int aid, Branch branch) {
		Hospital hospital = hospitalDao.getHospitalbyid(hid);
		branch.setHospital(hospital);
		Address address = addressDao.getAddressbyid(aid);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}

	public Branch updateBranch(int id, Branch branch) {
		Branch dbbranch = branchRepo.findById(id).get();
		if (dbbranch != null) {
			branch.setId(id);
			branch.setHospital(dbbranch.getHospital());
			branch.setAddress(dbbranch.getAddress());
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch deleteBranch(int id) {
		if (branchRepo.findById(id).isPresent()) {
			Branch branch = branchRepo.findById(id).get();
			branchRepo.deleteById(id);
			return branch;
		} else {
			return null;
		}

	}

	public Branch getBranchbyid(int id) {
		if (branchRepo.findById(id).isPresent()) {
			return branchRepo.findById(id).get();
		} else {
			return null;
		}
	}
	public List<Branch> getbranchbyhospitalid(int hid) {
		Hospital hospital=hospitalDao.getHospitalbyid(hid);
		return branchRepo.findbranchbyhospitalId(hospital);
	}
}
