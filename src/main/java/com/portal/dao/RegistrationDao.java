package com.portal.dao;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.portal.dto.MainPage;
import com.portal.dto.UserLogin;

@Repository
@Transactional
public class RegistrationDao {
	@Autowired
	SessionFactory factory;

	public void save(UserLogin user) {
		Session session = factory.getCurrentSession();

		session.save(user);
	}

	public void update(UserLogin user) {
		Session session = factory.getCurrentSession();

		session.update(user);
	}	
	
	public UserLogin getData(String lname, String paswd) {
		Session session = factory.getCurrentSession();

		Query nativequery = session.createQuery("from UserLogin where (loginName = :lname or emailAddress = :email) and password = :pswd");
		nativequery.setParameter("lname", lname);
		nativequery.setParameter("email", lname);
		nativequery.setParameter("pswd", paswd);
		UserLogin unqiue = (UserLogin) nativequery.uniqueResult();
		return unqiue;
	}

	public <T> Object getDataById(Class<T> clazz, UUID id) {
		Session session = factory.getCurrentSession();

		return session.get(clazz, id);
	}
	
}
