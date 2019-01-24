package com.grayash.manage.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grayash.manage.user.request.ManageUserRequest;
import com.grayash.manage.user.response.ManagerUserResponse;
import com.grayash.manage.user.response.Status;
import com.grayash.manage.user.service.ManageUserService;
import com.grayash.manage.user.util.CodeConstant;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/manageuser")
public class ManageUserController implements CodeConstant{
	
	private static final Logger Log = LoggerFactory.getLogger(ManageUserController.class);
	
	
	@Autowired
	private ManageUserService service;
	
	
	@ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = ManagerUserResponse.class),
            @ApiResponse(code = 412, message = "Precondition Failed"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
	@RequestMapping(value="/register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ManagerUserResponse> registerUser(@RequestBody ManageUserRequest request, HttpServletRequest servletRequest, @RequestHeader HttpHeaders headers) {
		if(Log.isDebugEnabled())
			Log.debug("Registration Request::"+request);
		ManagerUserResponse response = service.registerUser(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
