package com.tka.projectdemo.service;



import java.util.HashMap;

import java.util.List;
import java.util.Objects;


//import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.tka.projectdemo.dao.MainDao;
import com.tka.projectdemo.entity.Employee;
import com.tka.projectdemo.entity.country;

import org.springframework.stereotype.Service;






@Service
public class Mainservice {
	
	@Autowired
	MainDao dao;
	

	public String addcountry(country c) {
		      String msg= dao.addcountry(c);
		      if(Objects.isNull(msg)) {
					msg="Data is not Addedd Succefully..";
				}
				
				return msg;
		    
	}


	public String updatecountry(country uc) {
		      String msg= dao.updatecountry(uc);
		      
		      if(Objects.isNull(msg)) {
					msg="Data is Not Updatated...";
				}
				
				return msg;
	}


	public String deletecountry(country c) {
		       String msg=  dao.deletecountry(c);
		       if(Objects.isNull(msg)) {
		    	   msg="data is not deleted";
		       }
		return msg;
	}



	public String getParticularRecord(int cid) {
		 String msg=dao.getParticularRecord(cid);
		return msg;
	}
	

	  public List<country> getAllRecord() {
		 List<country>list=dao.getallrecord();
			return list;
		}
		
	  
//	  **************************************************************************************
	  
	  

	public String addEmployee(Employee e) {
		String msg= dao.addEmployee(e);
		
		if(Objects.isNull(msg)) {
			msg="Record is not be Added...";
		}
		
	return msg;
}


public String updateEmployee(Employee e) {
	 String msg=dao.updateEmployee(e);
	 
	 if(Objects.isNull(msg)) {
			msg="Record is not be updateted..";
		}
		 
	
	return msg;
}


public String deleteEmployee(int id) {
	 String msg=dao.deleteEmployee(id);

	 if(Objects.isNull(msg)) {
			msg="Record is not be deleted.";
		}
	 
	return msg;
}


public Employee getparticulardatabyid(int id) {
	 Employee employee=dao.getparticulardatabyid(id);
	 if(Objects.isNull(employee)) {
			employee=null;
		}
	return employee;
}


public List<Employee> gettallrecord() {
	  List<Employee>list=dao.gettallrecord();
	return list;
}


public List<Employee> getemployeebystatus(String status) {
	List<Employee>list=dao.getemployeebystatus(status);
	if(Objects.isNull(list)) {
		list=null;
	}
return list;
}


public HashMap checkuser(Employee emp) {
	Employee e=dao.checkuser(emp);
	HashMap map=new HashMap();
	if(Objects.isNull(e)) {
		map.put("msg", "invalid user");
		map.put("user", e);
	}else {
		map.put("msg", "valid user");
		map.put("user", e);
		
	}
	
	return map;
}




	

	
	
	
}
