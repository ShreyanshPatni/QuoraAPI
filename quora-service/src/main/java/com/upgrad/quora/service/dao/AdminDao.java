package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdminDao {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Delete a user from the DB.
     *
     * @param userEntity  user that needs to be deleted
     * @return the user who got deleted
     */
    public UserEntity deleteUser(UserEntity userEntity) {
        entityManager.remove(userEntity);
        return userEntity;
    }
}
