package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.UserDao;
import com.niit.model.User;

@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

  public UserDaoImpl()
  {
	  
	  
  }
	public UserDaoImpl(SessionFactory sessionFactory) {
     System.out.println("parameterised ");
		this.sessionFactory = sessionFactory;
	}
	//@Transactional
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
	
	
	 public List<User> getAllUsers() {
	        Session session = sessionFactory.openSession();
	        Query query = session.createQuery("from User");
	        List<User> usersDetail = query.list();

	        return usersDetail;
	    }
}