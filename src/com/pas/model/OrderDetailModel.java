package com.pas.model;

public class OrderDetailModel {
	private int o_d_id;
	private int o_id;
	private int t_id;
	private int pay_method;
	public int getO_d_id() {
		return o_d_id;
	}
	public void setO_d_id(int o_d_id) {
		this.o_d_id = o_d_id;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getPay_method() {
		return pay_method;
	}
	public void setPay_method(int pay_method) {
		this.pay_method = pay_method;
	}
}
