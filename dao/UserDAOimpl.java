package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecomm.model.UserDetail;

public class UserDAOimpl implements UserDAO {
    SessionFactory sessionFactory;
	public boolean registerUser(UserDetail user) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		 return false;
		}
	}

	public UserDetail getUser(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class, username);
		session.close();
		return userDetail;
	}

	public boolean updateUser(UserDetail user) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

}
