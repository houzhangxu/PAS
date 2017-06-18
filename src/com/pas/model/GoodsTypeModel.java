package com.pas.model;

import java.util.Date;

public class GoodsTypeModel {
	private  int g_t_id;
	private String name;
	private String unit;
	private int pid;
	private double create_time;
	public int getG_t_id() {
		return g_t_id;
	}
	public void setG_t_id(int g_t_id) {
		this.g_t_id = g_t_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public double getCreate_time() {
		return create_time;
	}
	public void setCreate_time(double create_time) {
		this.create_time = create_time;
	}
}
