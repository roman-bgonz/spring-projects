package com.in28minutes.springboot.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.jpa.entities.User;

@Repository
@Transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;

	public long insert(User user) {
		
		entityManager.persist(user);
		return user.getId();
	}
}
