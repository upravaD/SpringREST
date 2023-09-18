package com.aston;

import com.aston.dao.UserDAO;
import com.aston.entity.Permission;
import com.aston.entity.Role;
import com.aston.entity.User;
import com.aston.util.Queries;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Role role = new Role();
        role.setId(1L);

        User user = new User();
        user.setUsername("testUser");
        user.setRole(role);

        Configuration configuration = new Configuration();
        configuration.configure();

        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
//
            session.createNativeQuery(Queries.USER_CREATE.get(), User.class);
            session.persist(user);
//            List<User> resultList = session.createQuery("FROM User", User.class)
//                    .getResultList();
//            System.out.println(resultList);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}