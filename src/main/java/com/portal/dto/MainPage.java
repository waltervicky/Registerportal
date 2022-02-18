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
@Table(name = "Main_Page")
@Entity
public class MainPage {
  
	@Id
	@GeneratedValue
	
	@Column(name = "roomid")
	private UUID roomid;
	
	@Column(name = "winningprize")
	private String winningprize;
	
	@Column(name = "perkil")
	private String perkil;
	
	@Column(name = "entryfees")
	private String entryfees;
	
	@Column(name = "totalplayers")
	private String totalplayers;
	
	@Column(name = "activeplayers")
	private String activeplayers;
	
	@Column(name = "starttime")
	private String starttime;
	
	@Column(name = "gametype")
	private String gametype;
	
	@Column(name = "maptype")
	private String maptype;
}
