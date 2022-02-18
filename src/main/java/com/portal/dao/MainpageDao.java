package com.portal.dao;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.portal.dto.MainPage;


@Repository
@Transactional
public class MainpageDao {
	
	@Autowired
	SessionFactory factory;

	public void saveing(MainPage main) {
		Session session = factory.getCurrentSession();

		session.save(main);
	}
	
	public void updates(MainPage main) {
		Session session = factory.getCurrentSession();

		session.update(main);
	}

	public MainPage get(UUID roomId, Class<MainPage> clazz) {
		Session session = factory.getCurrentSession();
		return session.get(clazz, roomId);
	}
}
