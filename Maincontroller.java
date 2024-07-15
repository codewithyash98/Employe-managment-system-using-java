package com.tka.projectdemo.controller;

import java.util.HashMap;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tka.projectdemo.entity.Employee;
import com.tka.projectdemo.entity.country;
import com.tka.projectdemo.service.Mainservice;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class Maincontroller {

	@Autowired
	Mainservice service;
	
	
	
	@PostMapping("/addcountry")
	public  String addcountry(@RequestBody country c) {
		
		         String msg= service.addcountry(c);
		return msg;
	}
	
	@PutMapping("/updatecountry")
	public  String updatecountry(@RequestBody country uc) {
		 String msg= service.updatecountry(uc);
		 return msg;
		}
	
	
	
	@DeleteMapping("/deletecountry")
	 public String deletecountry (@RequestBody country c) {
		 String msg= service.deletecountry(c);
		 return msg;
		 
		
}
	
	

	@GetMapping("/getparticulardata/{cid}")
	public String getParticularRecordById(@PathVariable int cid) {
		
	String c= service.getParticularRecord(cid);
		return c;		
	}
	
	@GetMapping("/getAll")
	public List<country> getAllRecord(){
		
		List<country> list= service.getAllRecord();
		return list;
		
	}
	
//	***************/************/*************/*********/**************
	//   **Employee Entity**
	
	

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee e) {
		String c= service.addEmployee(e);
		return c;
	}
	
	
	
	@PutMapping("/updateEmployee")
	public String updateEmployee (@RequestBody  Employee e){
		
		
		String c=service.updateEmployee(e);
		return c;
		
		
	}
	

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg= service.deleteEmployee(id);
		return msg;
	}
	
	
	
	
	@GetMapping("/getp/{id}")
	public Employee getparticulardatabyid(@PathVariable int id) {
		
		        Employee employee=  service.getparticulardatabyid(id);
		              return employee;
	}
	
	
	@GetMapping("/getall")
	public List<Employee>getallrecord(){
	List<Employee>list=	service.gettallrecord();
		return list;
		
	}
	
	
	@GetMapping("/getbystatus/{status}")
	public List<Employee> getemployeebystatus(@PathVariable  String status) {
		List<Employee>list=service.getemployeebystatus(status);
		
		return list;
	}
	
	
	
	@PostMapping("/loginApi")
	public HashMap checkuser (@RequestBody Employee emp)
	{
		
		HashMap map= service.checkuser(emp);
		return map;
		
	}
	  
	
	
	
	
	
	
	
}
