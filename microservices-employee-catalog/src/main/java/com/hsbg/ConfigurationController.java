package com.hsbg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbg.models.DbSettings;

@RestController
public class ConfigurationController {

	@Autowired
	private DbSettings dbSettings;
	
	@Value("${my.country}")
	private String country;
	
	@Value("${list.of.states}")
	private List<String> stateList;
	
	public ConfigurationController() {
		
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/stateList")
	public List<String> printStateList() {
		System.out.println("Country "+country);
		System.out.println("StateList "+stateList);
		return stateList;
	}
	
	@RequestMapping("/configProps")
	public String printConfigProps() {
		return dbSettings.getConnectionString()+ " "+ dbSettings.getHost()+" "+dbSettings.getPort();
	}
}
