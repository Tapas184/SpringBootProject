package io.apsteer.controller;

public enum ErrorCode {

	SHOWCAPTCHA(-1);
	private int code;
	ErrorCode(int i) {
		this.code=i;
	}
	public int getCode() {
		return code;
	}
	
	
}
