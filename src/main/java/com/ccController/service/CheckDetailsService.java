package com.ccController.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ccController.DAO.CheckDetailsDao;
import com.ccController.model.Values;

@Service
public class CheckDetailsService {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	CheckDetailsDao checkdetailsdao;
	
	@Autowired
	Values value;
	
	public boolean checkMsisdn(String msisdn) {
		return checkdetailsdao.getDetails(msisdn).getMsisdn() != null ? true : false;
	}

	public int processRequest(String msisdn, String action,String pack,String lang) {
		try {
			if(checkMsisdn(msisdn)==true) {
				if("sub".equals(action)) {
					logger.info("User already subscribed");
					return 30;
				}
				else if("unsub".equals(action)) {
					logger.info("calling unsub URI");
					String str=value.getUnsubURI();
					String url= str.replaceAll("<msisdn>", msisdn);
					ResponseEntity<String> tokenResponse = restTemplate.getForEntity(url, String.class);
					if("-1".equals(tokenResponse)) {
						logger.info("User unsubscription failed");
						return 20;
					}
					else {
						logger.info("User unsubscription successfull");
						return 21;
					}
				}
				else {
					logger.info("Wrong Action Keyword");
					return 3;
				} 
			}else {
				if("sub".equals(action)) {
					logger.info("calling sub URI");
					String str=value.getSubURI();
					String url= str.replaceAll("<msisdn>", msisdn);
					url= url.replaceAll("<pack>", pack);
					url= url.replaceAll("<lang>", lang);
					ResponseEntity<String> tokenResponse = restTemplate.getForEntity(url, String.class);
					if("-1".equals(tokenResponse)){
						logger.info("User subscription failed");
						return 10;
					}
					else {
						logger.info("User subscription successfull");
						return 11;
					}
				}
				else {
				logger.info("User does not exist in vms_users table");
				 return 0;
				}
			}
		} catch (Exception e) {
			logger.info("Exception while processing user details in processRequest method: "+e);
			e.printStackTrace();
			return -1;
		}
	}
}
