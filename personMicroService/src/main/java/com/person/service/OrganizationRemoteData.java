package com.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.person.dto.OrganizationDTO;
import com.person.dto.client.OrganizationFeignClient;
import com.person.dto.client.OrganizationRestClient;
import com.person.filter.UserContextHolder;

@Component
public class OrganizationRemoteData {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganizationRemoteData.class); 
	
	@Autowired
	public OrganizationFeignClient organizationClient;
	
//	@Autowired
//	private OrganizationRestClient organizationClient;


	public OrganizationDTO getRemoteOrgData(int organizationId,String auth) {
		OrganizationDTO organizationDTO;
		logger.info("auth token is {}",UserContextHolder.getContext().getAuthToken());
		
		ResponseEntity<OrganizationDTO> reponse = organizationClient.getOrganization(auth,organizationId);
		organizationDTO = reponse.getBody();
		return organizationDTO;
	}
}