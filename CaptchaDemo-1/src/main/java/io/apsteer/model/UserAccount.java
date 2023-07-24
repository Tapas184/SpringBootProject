package io.apsteer.model;

import io.apsteer.controller.ErrorCode;
import lombok.Data;

@Data
public class UserAccount {

	private String userUuid;
	private Boolean isValid;
	private Integer attemptCount;
	private String recaptchaResponse;
	
	private String name;
	
	private String pass;
	
	private ErrorCode code;

	public void setCode(ErrorCode showcaptcha) {
		this.code=showcaptcha;
	}
}
