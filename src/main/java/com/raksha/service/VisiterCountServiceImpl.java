package com.raksha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raksha.repo.VisiterCountRepository;

@Service
@Transactional
public class VisiterCountServiceImpl implements VisiterCountService{

	@Autowired
	private VisiterCountRepository repo;
	
	@Override
	public void incrementCount() {
		// TODO Auto-generated method stub
		repo.incrementCount();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return repo.findById(0).get().getUserVisitedCount();
	}
	
	
	
	

}
