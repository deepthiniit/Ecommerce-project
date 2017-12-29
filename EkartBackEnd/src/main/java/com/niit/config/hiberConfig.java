package com.niit.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.SupplierDao;
import com.niit.Dao.UserDao;
import com.niit.DaoImpl.CategoryDaoImpl;
import com.niit.DaoImpl.SupplierDaoImpl;
import com.niit.DaoImpl.UserDaoImpl;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class hiberConfig {
	
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2Data()
	{
		DriverManagerDataSource dsource=new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/EkartBackend");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("H2 Connected");
		return dsource;
	}
	private Properties getHiber()
	{
		Properties p =new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto","update");
		p.put("hibernate.show_sql","true");
		
	    System.out.println("Data Table created in H2");
	
	return p;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getHiberSession()
	{
		System.out.println("inside getHiberSession() method");
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getH2Data());
		lsfb.addProperties(getHiber());
		lsfb.addAnnotatedClass(User.class);
		lsfb.addAnnotatedClass(Supplier.class);
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Product.class);
		return lsfb.buildSessionFactory();
	}	
	/*@Autowired
	@Bean(name="UserDao")
	public UserDao saveUserData(SessionFactory sf)
	{
	return new UserDaoImpl(sf);
	}*/
	
	
	/*@Autowired
	@Bean(name="SupplierDao")
	public SupplierDao saveSuppData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="CategoryrDao")
	public CategoryDao saveCatData(SessionFactory sf)
	{
	return new CategoryDaoImpl(sf);
	}*/

@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTrans(SessionFactory sf)
{
 HibernateTransactionManager tm= new  HibernateTransactionManager(sf);
 return tm;
}
}