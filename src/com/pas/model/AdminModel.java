package com.pas.model;

import java.util.*;

import javax.xml.crypto.Data;
public class AdminModel {
	private int a_id;
	private String admin_name;
	private String password;
	private int status;
	private Data create_time;
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Data getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Data create_time) {
		this.create_time = create_time;
	}
}
