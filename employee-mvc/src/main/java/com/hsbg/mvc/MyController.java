package com.hsbg.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("hello")
	public String hello() {
		return "Abc.jsp";
	}
	
	@RequestMapping("httpRequest")
	public String hi(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		System.out.println(name);
		req.getSession().setAttribute("name", name);
		return "Abc.jsp";
	}
	
	@RequestMapping("mvcRequest")
	//This method can take @PathVariable ect..
	public ModelAndView mvcRequest()
	{
		ModelAndView mv = new ModelAndView("mvcview.jsp");
		Employee emp = new Employee("1", "Vilas", 42);
		mv.addObject("empId", emp.getId());
		mv.addObject("empName", emp.getName());
		mv.addObject("empAge", emp.getAge());
		
		return mv;
	}
	
	
}
