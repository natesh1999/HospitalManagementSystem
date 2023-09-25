package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.AddressDao;
import com.ty.HospitalManagementSystem.dto.Address;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressdao;

	public Address saveAddress(Address address) {
		return addressdao.saveAddress(address);
	}

	public Address updateAddress(int id,Address address) {
		Address dbaddress=addressdao.updateAddress(id, address);
		if(dbaddress!=null) {
			return dbaddress;
		}else {
			throw new IdNotFoundException("id not found for Address");
		}
		
	}

	public Address deleteAddress(int id) {
		Address address = addressdao.deleteAddress(id);
		if (address != null) {
			return address;
		} else {
			return null;
		}
	}

	public Address getAddressbyid(int id) {
		Address address = addressdao.getAddressbyid(id);
		if (address != null) {
			return address;
		} else {
			return null;
		}
	}
}
