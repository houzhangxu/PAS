package com.pas.model;

public class ShoppingCartMoreModel {
	private int s_c_id;
	private int g_id;
	private String goods_name;
	private double price;
	private double total;
	
	public int getS_c_id() {
		return s_c_id;
	}
	public void setS_c_id(int s_c_id) {
		this.s_c_id = s_c_id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
