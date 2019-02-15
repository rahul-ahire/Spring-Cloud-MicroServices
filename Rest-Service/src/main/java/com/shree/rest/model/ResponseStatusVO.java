package com.shree.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResponseStatusVO {
	
	@JsonInclude(Include.NON_NULL)
	private String errorCode;
	
	private String message;

	@JsonInclude(Include.NON_NULL)
	private Throwable throwable;

	public ResponseStatusVO() {
		super();
	}

	public ResponseStatusVO(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.throwable = null;
	}

	public ResponseStatusVO(String errorCode, Throwable throwable) {
		super();
		this.errorCode = errorCode;
		this.message = throwable.getLocalizedMessage();
		this.throwable = throwable;
	}

	public ResponseStatusVO(Throwable throwable) {
		super();
		this.errorCode = "0000";
		this.message = throwable.getLocalizedMessage();
		this.throwable = throwable;
	}

	public static ResponseStatusVO createResponse(String errorCode, String message) {
		return new ResponseStatusVO(errorCode, message);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	@Override
	public String toString() {
		return "BaseModelVO [errorCode=" + errorCode + ", message=" + message + ", throwable=" + throwable + "]";
	}

}
