/**
 * 
 */
package com.person.dto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.person.dto.OrganizationDTO;

/**
 * @author chandresh.mishra
 *
 */
@FeignClient(name = "organizationservice", configuration = OrganizationClientConfig.class)
public interface OrganizationFeignClient {

	@GetMapping(path = "/getOrganization/{id}", produces = "application/json")
	public ResponseEntity<OrganizationDTO> getOrganization(@RequestHeader("Authorization") String auth, @PathVariable("id") Integer id);

}
