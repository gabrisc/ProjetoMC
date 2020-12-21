package com.example.demo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Double time;
	
	public StandardError(Integer status, String msg, Double time) {
		super();
		this.status = status;
		this.msg = msg;
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}
	
	
	
}
