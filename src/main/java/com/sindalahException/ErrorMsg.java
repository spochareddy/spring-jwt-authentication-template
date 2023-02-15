package com.sindalahException;

import java.io.Serializable;

public class ErrorMsg implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String[] params;

	public ErrorMsg() {
	}

	public ErrorMsg(String code) {
		this.code = code;
	}

	public ErrorMsg(String code, String param) {
		this.code = code;
		this.params = new String[] { param };
	}

	public ErrorMsg(String code, String[] params) {
		this.code = code;
		this.params = params;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String[] getParams() {
		return this.params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
}
