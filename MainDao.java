package com.tka.projectdemo.dao;

import java.util.List;





import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.tka.projectdemo.entity.Employee;
import com.tka.projectdemo.entity.country;

@Repository
public class MainDao {
  @Autowired
	SessionFactory factory;
	
	
	public String addcountry(country c) {
		
		
		
		
		
		Session session=null;
		Transaction  tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 session.persist(c);
		 tx.commit();
		 msg="Data Addedd Succefully..";
		 
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
		
	}


	public String updatecountry(country uc) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 country country= session.get(country .class,uc.getCid() );
		 
		 country.setCname(uc.getCname());
		 
		 session.merge(country);
		 tx.commit();
		 msg="Data is Updatated Successfully...";		 
		 
		
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	
	
	}


	public String deletecountry(country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 country country= session.get(country.class,c.getCid());
		 session.remove(country);
		 tx.commit();
		 msg="Data is deleted Successfully...";		 
		 
		
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	
	
	}




	public String  getParticularRecord(int cid) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 System.out.println(cid);
			 String hqlQuery="from country where cid=:myid";
			 Query<country> query= session.createQuery(hqlQuery,country.class);
				query.setParameter("myid",cid );
				
				country c= query.uniqueResult();
			 
			 
				
				 tx.commit();
				 msg="Data is getted Successfully...";	
		}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
							
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
		
		return msg;
	}




	public List<country> getallrecord() {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<country>list=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 String strQuery="from country";
				
				Query<country> query= session.createQuery(strQuery,country.class);
				
				 list= query.list();
				tx.commit();
				 msg="record is fetch succesfull";
				 
					}catch (Exception e1) {
						if(tx!=null) {
							tx.rollback();
						}
									
						e1.printStackTrace();
					}finally {
						if(session!=null) {
							session.close();
						}
					}
				 
				
				return list;
		
	}


	
	//*****************************//*********//******//*////*****************



public String addEmployee(Employee e) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	try {		
	 session= factory.openSession();
	 tx=session.beginTransaction();
	 
	 session.persist(e);
	 tx.commit();
	 msg="Record is Addedd Successfully";
	 
	 
	}catch (Exception e1) {
		if(tx!=null) {
			tx.rollback();
		}
					
		e1.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;
	
}


public String deleteEmployee(int id) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	try {		
	 session= factory.openSession();
	 tx=session.beginTransaction();
	 Employee employee= session.get(Employee.class,id);
	 session.remove(employee);
	 tx.commit();
	 msg="record is deleted succesfull";
	 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	 
	
	return msg;
}


public String updateEmployee(Employee e) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	try {		
	 session= factory.openSession();
	 tx=session.beginTransaction();
	 Employee employee= session.get(Employee.class,e.getId());
	 employee.setName(e.getName());
	 employee.setPhoneno(e.getPhoneno());
	 employee.setDepartment(e.getDepartment());
	 employee.setCreateddtm(e.getCreateddtm());
	 employee.setCreatedby(e.getCreatedby());
	 employee.setCountry(e.getCountry());
	 employee.setStatus(e.getStatus());
	 employee.setUpdatedby(e.getUpdatedby());
	 employee.setUpdateddtm(e.getUpdateddtm());
	 session.merge(e);
	 tx.commit();
	 msg="record is updatetd succesfull";
	 
		}catch (Exception e2) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e2.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	 
	
	return msg;
	
}


public Employee getparticulardatabyid(int id) {


	Session session=null;
	Transaction tx=null;
	String msg=null;
	Employee employee= null;
	try {		
	 session= factory.openSession();
	 tx=session.beginTransaction();
	   employee=session.get(Employee.class,id);
		
	 
	 tx.commit();
	 
	 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	 
	
	return employee;
	
}



//*** by hql quer 
//public Employee getparticulardatabyid(int id) {
//
//
//	Session session=null;
//	Transaction tx=null;
//	String msg=null;
//	Employee employee= null;
//	 String strquery="from Employee where id=:myid";
//	try {		
//	 session= factory.openSession();
//	 tx=session.beginTransaction();
//
//	 Query<Employee> query= session.createQuery(strquery,Employee.class);
//		query.setParameter("myid",id );
//		
// employee= query.uniqueResult();
//		tx.commit();
//		 
//		 
//	}catch (Exception e1) {
//		if(tx!=null) {
//			tx.rollback();
//		}
//					
//		e1.printStackTrace();
//	}finally {
//		if(session!=null) {
//			session.close();
//		}
//	}
// 
//
//return employee;
//}


public List<Employee> gettallrecord() {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	List<Employee>list=null;
	try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 String strQuery="from Employee";
			
			Query<Employee> query= session.createQuery(strQuery,Employee.class);
			
			 list= query.list();
			tx.commit();
			 msg="record is fetch succesfull";

	}catch (Exception e1) {
		if(tx!=null) {
			tx.rollback();
		}
					
		e1.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
 

return list;

		 
		
	
}


public List<Employee> getemployeebystatus(String status) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	List<Employee>list=null;
	String strquery="from Employee where  status=:mystatus";
	try {		
	 session= factory.openSession();
	 tx=session.beginTransaction();
	 Query<Employee> query= session.createQuery(strquery,Employee.class);
		query.setParameter("mystatus",status );
		list=query.list();
	 tx.commit();
	 
	 
	 
     }catch (Exception e1) {
	if(tx!=null) {
		tx.rollback();
	}
				
	e1.printStackTrace();
     }finally {
	if(session!=null) {
		session.close();
     	}
}


return list;
	
}


public Employee checkuser(Employee emp) {
	Session session=null;
	Transaction tx=null;
	//String msg=null;
	 String strQuery="from Employee where name=:name and phoneno=:phoneno";
	Employee employee =null;
	try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		
		 
		 Query<Employee> query= session.createQuery(strQuery,Employee.class);
		 
		 
			query.setParameter("name",emp.getName());
			query.setParameter("phoneno",emp.getName());
			
			employee=query.uniqueResult();
			 tx.commit();
			 
	}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
	
	return employee;


	
}








}