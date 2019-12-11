package com.mercury.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="msi_user_profile")
public class UserProfile implements GrantedAuthority {
	@Id
	private long id;
	@Column
	private String type;
	public UserProfile() {
		super();
	}
	public UserProfile(long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", type=" + type + "]";
	}
	@Override
	public String getAuthority() {
		return type; // 存的名字是 type
	}
}
