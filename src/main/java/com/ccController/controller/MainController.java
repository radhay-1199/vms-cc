package com.ccController.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ccController.model.VmsUsersModel;
import com.ccController.service.CheckDetailsService;
import com.ccController.service.VmsUsersService;

@Controller
public class MainController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CheckDetailsService checkdetailsservice;
	@Autowired
	VmsUsersService vmsUsersService;

	@GetMapping("/index")
	public ModelAndView indexpage() {
		ModelAndView mv = new ModelAndView("index.html");
		return mv;
	}
	@GetMapping("/checkdetails")
	public ResponseEntity<?> checkDetails(@RequestParam String msisdn, @RequestParam String action,@RequestParam String pack,@RequestParam String lang){
		logger.info("msisdn: "+msisdn);
		logger.info("action: "+action);
		logger.info("pack: "+pack);
		logger.info("lang: "+lang);
		Integer res=checkdetailsservice.processRequest(msisdn,action,pack,lang);
		Map<String,String> map = new HashMap<>();
		if(res==11) {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","Your subscription is successfull");
			return new ResponseEntity(map, HttpStatus.OK);
		}
		else if(res==10) {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","Your subscription is failed");
			return new ResponseEntity(map, HttpStatus.OK);
		}
		if(res==21) {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","Your unubscription is successfull");
			return new ResponseEntity(map, HttpStatus.OK);
		}
		else if(res==20) {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","Your unsubsciption has failed");
			return new ResponseEntity(map, HttpStatus.OK);
		}
		else if (res==0) {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","User does not exist");
			return new ResponseEntity(map, HttpStatus.OK);
		}
		else if (res==3) {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","Wrong action Keyword");
			return new ResponseEntity(map, HttpStatus.OK);
		}
		else if(res==30) {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","User already subscribed");
			return new ResponseEntity(map, HttpStatus.OK);
		}
		else {
			map.put("ResponseCode", res.toString());
			map.put("ResponseMessage","There is an Exception");
			return new ResponseEntity(map, HttpStatus.OK);
		}
	}
	@GetMapping("/getdetails")
	public  ResponseEntity<?> getDetails(String msisdn){
		VmsUsersModel vmsUser = vmsUsersService.getDetails(msisdn);
		System.out.println(vmsUser);
		return new ResponseEntity(vmsUser, HttpStatus.OK);
	}
}
