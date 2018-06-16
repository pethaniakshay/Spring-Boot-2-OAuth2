package com.codepuran.OAuth2.controller;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codepuran.OAuth2.model.CustomPrincipal;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@RestController
public class ResourceController {

	@GetMapping("/context")
	@PreAuthorize("hasAuthority('role_admin')")
	public String context() {
		/*CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();*/
		//return principal.getUsername() + " " + principal.getEmail();
		return SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal().toString();
		
	}

	@GetMapping("/secured")
	@PreAuthorize("hasAuthority('role_admin')")
	public String secured(CustomPrincipal principal) {
		//return principal.getUsername() + " " + principal.getEmail();
		return "Hey Aksh You Are Great";
	}

	@GetMapping("/resource")
	public String resource() {
		return UUID.randomUUID().toString();
	}
}
