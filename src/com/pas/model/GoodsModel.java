package com.pas.model;

import java.util.Date;

public class GoodsModel {
	
	private int g_id;
	private String goods_name;
	private String goods_main;
	private int goods_type;
	private double price;
	private double total;
	private int creator;
	private double create_time;
	
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
	public int getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(int goods_type) {
		this.goods_type = goods_type;
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
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public double getCreate_time() {
		return create_time;
	}
	public void setCreate_time(double create_time) {
		this.create_time = create_time;
	}
	public String getGoods_main() {
		return goods_main;
	}
	public void setGoods_main(String goods_main) {
		this.goods_main = goods_main;
	}
	
}
