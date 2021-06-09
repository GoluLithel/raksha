package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.Insurance;
import com.raksha.repo.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	
	@Autowired
	private InsuranceRepository repo;
	
	@Override
	public void addInsurance(Insurance insurance) {
		repo.save(insurance);
	}

	@Override
	public Insurance getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Insurance> getAllInsurance() {
		return repo.findAll();
	}

	@Override
	public void removeInsurance(int id) {
		repo.deleteById(id);;
	}

}
