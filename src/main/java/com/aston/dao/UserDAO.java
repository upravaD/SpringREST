package com.aston.dao;

import com.aston.entity.User;
import com.aston.util.Queries;
import java.util.Collections;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class UserDAO implements DAO<User> {
    private final SessionFactory sessionFactory;

//    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean create(User user) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getAll() {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery(Queries.USER_GET_ALL.get(), User.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public User findById(Long id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.merge(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.remove(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
