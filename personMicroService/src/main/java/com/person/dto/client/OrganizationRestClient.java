/**
 * 
 */
package com.person.dto.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.person.dto.OrganizationDTO;

/**
 * @author chandresh
 *
 */
@Component
public class OrganizationRestClient {

	@Autowired
	private  RestTemplate restTemplate;
	
	public ResponseEntity<OrganizationDTO> getOrganization(Integer id){
		String auth="Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IkFCQ0RFRiIsInVzZXJfbmFtZSI6ImNoYW5kcmVzaC5taXNocmEiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNTczNjk4NTM2LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImYxNDczYjdjLWM3ZDgtNDRkOS04NTcwLWVlMjk3NzkyYWNmNyIsImNsaWVudF9pZCI6IklUTVAifQ.PRSMjYRnYR84UMMkZAhJMmeMw6YghyCeFCsZ8jEmxN7jCQj47l6qTgjx6WoZWEFcVHchSVt68Ngw4CgOWtpA-6pmq5JNO3u4vfqI8GW6r71EryuEDpa0q5qK4Orx_LMpOn0GwuJhhEprwBzarZEBqB6_ZKfH0zKNu9UUXOjpd93laW1UAWGkvIYfwfNb7jdUZmvZWK2JcBEthu2v5oA3L1HfYcROB3fqJO54C9LCCD_VgdGGHlyu7nAeaPgbgsz6Z0MTMgXuDnUJhfxxlseIfqIzwu7NQfh4ZwKR5kebE7KxMAzL8NBfKbe5EY_I2cG-U4dj2HKpZb87UXiwMSG_Hg";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", auth);

		HttpEntity<?> entity = new HttpEntity<>(headers);
		return restTemplate.exchange("http://organizationservice/getOrganization/{id}", HttpMethod.GET,entity,OrganizationDTO.class,id);
}
}
