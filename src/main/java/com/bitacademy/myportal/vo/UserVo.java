package com.bitacademy.myportal.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	private Long no;
	@NotEmpty
	@Length(min=2,max=8)
	private String name;
	private String password;
	@NotEmpty
	@Email
	private String email;
	private String gender;
	private Date createdAt;
	
	//생성자
	public UserVo() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", createdAt=" + createdAt + "]";
	}

	public Long getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
