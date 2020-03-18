package com.ccController.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccController.DAO.VmsUsersDao;
import com.ccController.model.VmsUsersModel;

@Service
public class VmsUsersService {
	@Autowired
	VmsUsersDao vmsUsersDao;
	
	public VmsUsersModel getDetails(String msisdn){
		return vmsUsersDao.getUserDetails(msisdn);
	}
}
