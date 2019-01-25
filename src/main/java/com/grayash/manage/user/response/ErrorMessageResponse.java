package com.grayash.manage.user.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorMessageResponse extends Status{
	
	public ErrorMessageResponse(String msgCode, String msgText) {
		this.msgCode = msgCode;
		this.msgText = msgText;
	}
	
	private String msgCode;
	private String msgText;

}
