package com.hsbg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsbg.security.models.AuthenticationRequest;
import com.hsbg.security.models.AuthenticationResponse;

@RestController
public class CompanySecurityController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailService userDetailsService;
	
	@Autowired
	private JwtTockenManager jwtTockenManager;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!!";
	}
	
	@RequestMapping(value="/authenticate", method= RequestMethod.POST)
	public ResponseEntity<?> createAthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		System.out.println(authenticationRequest.getUsername() +authenticationRequest.getPassword());
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken( authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException be) {
			//throw new Exception("Incorrect username or pwd",be);
			System.out.println("failed");
		}
		System.out.println("2");
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("3");
		final String jwt = jwtTockenManager.generateToken(userDetails);
		System.out.println("4");
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
