package com.pas.model;

public class OrderGoodsModel {
	private int o_g_id;
	private int o_id;
	private int g_id;
	private float discount;
	private float total;
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
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
}
