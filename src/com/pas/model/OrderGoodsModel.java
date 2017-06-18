package com.pas.model;

import java.util.Date;

public class OrderGoodsModel {
	private int o_g_id;
	private int o_id;
	private int g_id;
	private int discount;
	private double total;
	private double create_time;
	public int getO_g_id() {
		return o_g_id;
	}
	public void setO_g_id(int o_g_id) {
		this.o_g_id = o_g_id;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCreate_time() {
		return create_time;
	}
	public void setCreate_time(double create_time) {
		this.create_time = create_time;
	}
}
