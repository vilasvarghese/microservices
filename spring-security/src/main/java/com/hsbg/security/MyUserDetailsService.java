package com.hsbg.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

	List<String> userList = Arrays.asList("Vilas", "Mohammad", "Swapna", "Nagendra", "Noor", "Raj");
	
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //return new User("vilas", "vilas",new ArrayList<>());
    	userList.contains(s);
    	return new User(s, s,new ArrayList<>());
    }
}