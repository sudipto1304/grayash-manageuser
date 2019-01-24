package com.grayash.manage.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grayash.manage.user.config.FeignClientConfiguration;
import com.grayash.manage.user.request.ManageUserRequest;
import com.grayash.manage.user.response.ManagerUserResponse;


@FeignClient(name = "CrudService", configuration=FeignClientConfiguration.class)
public interface CrudManageUserClient {
	
	@RequestMapping(method = RequestMethod.POST, path = "/manageuser/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ManagerUserResponse registerUser(@RequestBody ManageUserRequest request);

}
