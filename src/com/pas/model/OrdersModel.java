package com.pas.model;

import java.util.Date;

public class OrdersModel {
	private int o_id;
	private  int u_id;
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
