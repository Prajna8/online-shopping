package com.london.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;           //date source is coming form here
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager; // told you 
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder; // double check the version
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

/*
 * * this is where my entity class will be
 */
@ComponentScan(basePackages={"com.london.shoppingbackend.dto"}) 


@EnableTransactionManagement
public class HibernateConfig {
	
	/*
	 * * Information about database one should be aware of
	 */
	
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	
	/*
	 * * DataSource beans
	 */
	@Bean
	public DataSource getDataSource(){
		
		BasicDataSource dataSource = new BasicDataSource();
	
	// providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
		
	}
	
	/*
	 * * SessionFactory beans
	 */
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.london.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}

	
	
	// all the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		
Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
//		this will drop the table everytime and recreate it
		
		properties.put("hibernate.hbm2ddl.auto","update");
		
		return properties;
	}
	
	/*
	 * * All transactionManager Bean created to manage the transaction
	 */
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
				return transactionManager;
	}
	

}
