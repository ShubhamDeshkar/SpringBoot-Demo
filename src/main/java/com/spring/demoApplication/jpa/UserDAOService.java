package com.spring.demoApplication.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(UserJPA userJPA) {
        entityManager.persist(userJPA);
        return userJPA.getId();
    }
}
