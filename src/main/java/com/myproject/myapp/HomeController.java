package com.myproject.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.myapp.domain.User;
import com.myproject.myapp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("welcome", "Spring Web application project." );
		
		return "home";
	}
	
	@RequestMapping(value= "/home", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> testRestRequest(){
		logger.info("home controller is being called");
		Map<String, Object> responseObject = new HashMap<String, Object>();
		List<String> myList =  new ArrayList<String>();
		myList.add("list_1");
		myList.add("list_2");
		myList.add("list_3");
		myList.add("list_4");
		
		User user = new User();
		user.setEmail("abc@email.com");
		user.setUserName("user_1");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		
		user = userService.create(user);
		
		responseObject.put("reponseList", myList);
		responseObject.put("user", user);
		return new ResponseEntity<Map<String,Object>>(responseObject, HttpStatus.OK);
	}
	
}
