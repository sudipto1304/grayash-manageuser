package com.grayash.manage.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayash.exception.UserPresentException;
import com.grayash.manage.user.client.CrudManageUserClient;
import com.grayash.manage.user.request.ManageUserRequest;
import com.grayash.manage.user.response.ManagerUserResponse;

@Service
public class ManageUserService {
	
	private static final Logger Log = LoggerFactory.getLogger(ManageUserService.class);

	@Autowired
	private CrudManageUserClient crudClient;
	
	 public ManagerUserResponse registerUser(ManageUserRequest request) throws UserPresentException {
		 ManagerUserResponse response = null;
		 System.out.println(crudClient.registerUser(request));
		 if(Log.isDebugEnabled())
			 Log.debug("Crud response for registerUser::"+response);
		 return response;
		 
	 }
}
