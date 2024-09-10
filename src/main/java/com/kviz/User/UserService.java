package com.kviz.User;

import com.kviz.AbstractService;
import com.kviz.Answer.Answer;
import jakarta.persistence.*;

public class UserService extends AbstractService<User> {

    EntityManager entityManager;

    public UserService() {
        super(User.class);
    }

    @Override
    protected EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
        return entityManager;
    }

    public User login(String uname, String pass) {
        EntityManager em =entityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createNamedQuery("User.findByUsernamePass");
            query.setParameter("username", uname);
            query.setParameter("password", pass);
            User user = (User) query.getSingleResult();
            if (user != null) {
                return user;
            }
            //return null;
        } catch (NoResultException e) {
            System.out.println("Error: "+e.getMessage());

        }
        return null;
    }

    public User findByUsername(String uname) {
        EntityManager em =entityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createNamedQuery("User.findByUsername");
            query.setParameter("username", uname);
            User user = (User) query.getSingleResult();

            if (user != null) {
                return user;
            }
        } catch (NoResultException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }

    public User register(String username, String password) {
        EntityManager em = entityManager();
        em.getTransaction().begin();
        User user = findByUsername(username);
        if (user != null) {
            return user;
        } else {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            em.persist(user);
            em.getTransaction().commit();

        }
        return null;
    }


}
