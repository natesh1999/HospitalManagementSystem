package com.ty.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.BranchDao;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public Branch saveBranch(int hid, int aid, Branch branch) {
		return branchDao.saveBranch(hid, aid, branch);
	}

	public Branch updateBranch(int id, Branch branch) {
		Branch dbbranch = branchDao.updateBranch(id, branch);
		if (dbbranch != null) {
			return dbbranch;
		} else {
			throw new IdNotFoundException("id not found for branch service");
		}
	}

	public Branch deleteBranch(int id) {
		Branch branch = branchDao.deleteBranch(id);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}
	}

	public Branch getbranchbyid(int id) {
		Branch branch = branchDao.getBranchbyid(id);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}
	}

	public List<Branch> getBranchbyhospitalid(int hid) {
		List<Branch> branchs = branchDao.getbranchbyhospitalid(hid);
		if (branchs != null) {
			return branchs;
		} else {
			return null;
		}
	}
}
