package com.grayash.manage.user.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grayash.auditactivity.utils.CommonUtils;
import com.grayash.exception.FeignCustomException;
import com.grayash.manage.user.client.CrudManageUserClient;
import com.grayash.manage.user.response.Status;
import com.grayash.manage.user.util.CodeConstant;

@SuppressWarnings("Duplicates")
@ControllerAdvice
public class ManageUserExceptionHandler extends ResponseEntityExceptionHandler implements CodeConstant{

	private static final Logger Log = LoggerFactory.getLogger(ManageUserExceptionHandler.class);
	
	@Autowired
	private CrudManageUserClient client;

	
	@ExceptionHandler(value = FeignCustomException.class)
	protected ResponseEntity<Object> handleGlobalException(FeignCustomException ex, WebRequest request) {
		Status status = new Status();
		status.setResponseCode(ex.getResponseCode());
		status.setResponseMsg(ex.getResponseMsg());
		status.setHttpCode(ex.getHttpCode());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return handleExceptionInternal(ex, CommonUtils.constructJsonResponse(status), headers,
				ex.getHttpCode(), request);
	}

}
