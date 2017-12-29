package com.niit.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.CategoryDao;
import com.niit.model.Category;



@Repository("CategoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

public CategoryDaoImpl()
{
	System.out.println(" default");
}
	public CategoryDaoImpl(SessionFactory sessionFactory) {
     System.out.println("parameterised ");
		this.sessionFactory = sessionFactory;
	}
	//@Transactional
	public void insertCategory(Category category) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
	}

}
