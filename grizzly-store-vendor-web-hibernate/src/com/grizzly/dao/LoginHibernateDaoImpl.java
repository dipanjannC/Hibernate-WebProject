package com.grizzly.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.grizzly.entity.UserDetailsEntity;
import com.grizzly.pojo.LoginPojo;
import com.grizzly.validation.WebsiteException;

public class LoginHibernateDaoImpl implements LoginHibernateDao {

	
	public  LoginPojo loginValidation(LoginPojo pojo) throws WebsiteException
	{
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		
		LoginPojo userDetailsPojo=new LoginPojo();
	
		
		/*
		 * Using HQL to fetch.
		 * 
		 * String hql="from UserDetailsEntity where username='"+pojo.getUsername()+"'";
		List<UserDetailsEntity> userDetailsList=(List<UserDetailsEntity>)session.createQuery(hql).list(); 
		Iterator<UserDetailsEntity> itr=userDetailsList.iterator();
	
		while(itr.hasNext())
		{
			 UserDetailsEntity loginEntity=itr.next();
			 userDetailsPojo.setUsername(loginEntity.getUsername());
			 userDetailsPojo.setPassword(loginEntity.getPassword());
			 userDetailsPojo.setRole(loginEntity.getRole());
			 userDetailsPojo.setStatus(loginEntity.getStatus());
			
		}*/
		
		UserDetailsEntity loginEntity=session.get(UserDetailsEntity.class, pojo.getUsername());
		
		if(loginEntity!=null)
		{
		 userDetailsPojo.setUsername(loginEntity.getUsername());
		 userDetailsPojo.setPassword(loginEntity.getPassword());
		 userDetailsPojo.setRole(loginEntity.getRole());
		 userDetailsPojo.setStatus(loginEntity.getStatus());
		}
		
		return userDetailsPojo;
	
	}
	
	public int lockAccount(String username) throws WebsiteException
	{
		//Establishing connection with the database
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		String status="inactive";
		int update=0;
		
		// Executing query to lock the account in user_details
		Transaction transaction = session.beginTransaction();
		UserDetailsEntity userDetails=session.get(UserDetailsEntity.class, username);
		userDetails.setStatus(status);
		session.update(userDetails);
		transaction.commit();
		
		return update;
	}
	
	
}
