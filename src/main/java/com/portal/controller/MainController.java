package com.portal.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.dao.MainpageDao;
import com.portal.dto.MainPage;


@RequestMapping("/MainInformation")
@RestController
public class MainController {
	
	@Autowired
	MainpageDao dao;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/main")
	public Map<String, String> Mainpagesave(@RequestBody String mainpage) {
		Map<String, String> map = new HashMap<>();
		try {
			MainPage Main = mapper.readValue(mainpage, MainPage.class);
			dao.saveing(Main);
			map.put("Status", "Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block

			map.put("Status", "Failed");
			map.put("Message", "Name or email alredy exist");
			e.printStackTrace();
		}
		return map;
	}
	
	
	@GetMapping("/updateMain/{roomId}")
	public Map<String, String> Updated(@PathVariable String roomId, @RequestBody String mainPage) {
		Map<String,String> map = new HashMap<>();
	   try {
		   MainPage dbMain = dao.get(UUID.fromString("7fc68c35-da67-4caf-aa45-e5bac6118e4d"), MainPage.class);
		   MainPage main = mapper.readValue(mainPage, MainPage.class);
		   dbMain.setActiveplayers(main.getActiveplayers());
		   dbMain.setEntryfees(main.getEntryfees());
		   dbMain.setGametype(main.getGametype());
		   dbMain.setMaptype(main.getMaptype());
		   dbMain.setTotalplayers(main.getTotalplayers());
		   dbMain.setWinningprize(main.getWinningprize());
		   		   
		//login.setPhoto(profile.getBytes());
			dao.updates(dbMain);
			map.put("Status", "Success");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		map.put("Status", "Failed");
		//map.put("Message", "Name or email alredy exist");
		e.printStackTrace();
	}
		return map;
	}

}
