package com.pas.model;

public class OrderMoreModel {
	private int o_id;
	private  int u_id;
	private String username;
	private int status;
	private double create_time;
	
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getCreate_time() {
		return create_time;
	}
	public void setCreate_time(double create_time) {
		this.create_time = create_time;
	}
	
}
