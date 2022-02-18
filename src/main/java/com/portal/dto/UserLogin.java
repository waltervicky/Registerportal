package com.portal.dto;

import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "user_login")
@Entity
public class UserLogin {
	@Id
	@GeneratedValue
	@Column(name = "userid")
	private UUID userId;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "loginname")
	private String loginName;
	
	@Column(name = "emailaddress")
	private String emailAddress;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "photo")
	private byte[] photo;
}
