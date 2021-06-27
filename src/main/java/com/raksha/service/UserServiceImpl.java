package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.User;
import com.raksha.mail.Mail;
import com.raksha.repo.UserRepository;
import com.raksha.response.OTPResponse;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public int addUser(User user) {
		int emailCount = repo.emailCount(user.getGmail());
		int mobileCount = repo.mobileCount(user.getMobileNo());
		if(emailCount >= 1 && mobileCount >= 1) {
			return 0; //email and mobile is already at database ...
		}else if(emailCount >= 1) {
			return -1; //email is already at database ...
		}else if(mobileCount >= 1) {
			return -2; //mobile is already at database ...
		}
		repo.save(user);
		return user.getId();
	}

	@Override
	public User getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public void removeUser(int id) {
		repo.deleteById(id);
	}

	
	@Override
	public long getUserCount() {
		// TODO Auto-generated method stub
		return repo.getUserCount();
	}

	@Override
	public void updateUser(User user) {

		
	}

	@Override
	public OTPResponse verifyMail(String mail) {
		OTPResponse otpResponse = new OTPResponse();
		if(repo.emailCount(mail)>=1) {
			otpResponse.setOTP("NO OTP"); 
			otpResponse.setStatus("EMAIL IS ALREADY USED");
			return otpResponse;
		}
		return Mail.sendOTP(mail);
	}

}
