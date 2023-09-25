package com.ty.HospitalManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService service;

	@ApiOperation(value = "Save Branch",notes = "Api is used to save branch")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping("/savebranch")
	public Branch saveBranch(@Valid @RequestParam int hid, @RequestParam int aid, @RequestBody Branch branch) {
		return service.saveBranch(hid, aid, branch);
	}

	@PutMapping("/updatebranch")
	public Branch updateBranch(@Valid @RequestParam int id, @RequestBody Branch branch) {
		return service.updateBranch(id, branch);
	}

	@DeleteMapping("/deletebranch")
	public Branch deleteBranch(@Valid @RequestParam int id) {
		return service.deleteBranch(id);
	}

	@GetMapping("/getbranchbyid")
	public Branch getbranchbyid(@Valid @RequestParam int id) {
		return service.getbranchbyid(id);
	}

	@GetMapping("/getbranchbyhospitalid")
	public List<Branch> getbranchbyhospitalid(@Valid @RequestParam int id) {
		return service.getBranchbyhospitalid(id);

	}
}
