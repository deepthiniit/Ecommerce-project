package com.niit.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.SupplierDao;
import com.niit.model.Supplier;



@Repository("SupplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;

public SupplierDaoImpl()
{
	System.out.println(" default");
}
	public SupplierDaoImpl(SessionFactory sessionFactory) {
     System.out.println("parameterised ");
		this.sessionFactory = sessionFactory;
	}
	//@Transactional
	public void insertSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
	}

}
