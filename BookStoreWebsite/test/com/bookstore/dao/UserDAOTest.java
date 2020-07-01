package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO; 
	
	@BeforeClass
	public static void setupClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
	    userDAO = new UserDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("pablo.besta@gmail.com");
		user1.setFullName("Pablo Souza");
		user1.setPassword("123456");
		
		
	    user1 = userDAO.create(user1);
	    
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();	
	    user1 = userDAO.create(user1);    
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test
	public void testUpdateUsers() {
		Users user = new Users();	
	    user.setUserId(1);
	    user.setEmail("bestao@gmail.com");
	    user.setFullName("Pablote");
	    user.setPassword("654321");
	    
	    user = userDAO.update(user);
        String expected = "654321";
        String actual = user.getPassword();
	    
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1; 
		Users user = userDAO.get(userId);
		if (user!=null) {
			System.out.println(user.getEmail());
		}
		
		assertNotNull(user);		
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId=99;
		Users user = userDAO.get(userId);
		
		assertNull(user);		
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 1;
		userDAO.delete(userId);
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
