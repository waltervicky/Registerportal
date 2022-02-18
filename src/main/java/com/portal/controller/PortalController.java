package com.portal.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.dao.RegistrationDao;
import com.portal.dto.UserLogin;
@RequestMapping("/userInformation")
@RestController
public class PortalController {

	@Autowired
	RegistrationDao dao;

	ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/testPortal")
	public String portalTesting() {
		return "Yes it works!";
	}

	@GetMapping("/showPortal")
	public ModelAndView showTestPortal(@RequestParam(name = "mode", required = false) String mode,
			HttpServletRequest request) {
		System.out.println("loginigm-->" + mode);
		request.getSession(true).setAttribute("mode", mode);
		return new ModelAndView("login.jsp");
	}

	@GetMapping("/ForgetPassword")
	public ModelAndView ForgetPassword() {
		return new ModelAndView("forgot-password.jsp");
	}

	@GetMapping("/MainPortal")
	public ModelAndView showMainPortal(HttpServletRequest request) {
	     
		return new ModelAndView("index.jsp");
	}

	@PostMapping("/userlogin")
	public Map<String, String> logins(@RequestParam String lname,@RequestParam String paswd, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		try {
			UserLogin login = dao.getData(lname, paswd);
			if (login != null) {
				request.getSession(false).setAttribute("userId", login.getUserId());
				request.getSession(false).setAttribute("username",login.getLoginName());
				map.put("Status", "Success");

				map.put("userId", login.getUserId().toString());
			} else {
				map.put("Status", "Failed");
				map.put("Message", "Name or Password is wrong");
			}
			//System.out.println(loginst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@PostMapping("/register")
	public Map<String, String> registration(@RequestBody String userloginst) {
		Map<String, String> map = new HashMap<>();
		try {
			UserLogin login = mapper.readValue(userloginst, UserLogin.class);
			dao.save(login);
			map.put("Status", "Success");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			map.put("Status", "Failed");
			map.put("Message", "Name or email alredy exist");
			e.printStackTrace();
		}
		return map;
	}

	@GetMapping("/getUserInfo/{userId}")
	public Object getUserInfo(@PathVariable String userId) {
		ModelAndView model = new ModelAndView("MainPage");
		Object userobj1 = dao.getDataById(UserLogin.class, UUID.fromString(userId));
		System.out.println(userobj1 + "userobj1");
		if (userobj1 != null) {

			return userobj1;
		} else {
			return null;
		}

	}

	
	@PostMapping("/update")
	public Map<String, String> Update(@RequestParam String userLoginst, @RequestParam MultipartFile profile) {
		Map<String,String> map = new HashMap<>();
	   try {
		UserLogin login = mapper.readValue(userLoginst, UserLogin.class);
		login.setPhoto(profile.getBytes());
		dao.update(login);
		map.put("Status", "Success");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		map.put("Status", "Failed");
		map.put("Message", "Name or email alredy exist");
		e.printStackTrace();
	}
		return map;
	}
	
	@GetMapping("/TournamentPlayed")
	public ModelAndView TournamentPlayed() {
		return new ModelAndView("TournamentPlayed.jsp");
	}
	
	@GetMapping("/Leaderboard")
	public ModelAndView Leaderboard() {
		return new ModelAndView("Leaderboard.jsp");
	}
	
	@GetMapping("/HelpandSupport")
	public ModelAndView HelpandSupport() {
		return new ModelAndView("helpAndSupport.jsp");
	}
	
}
