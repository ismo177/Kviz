package com.kviz.Answer;


import com.kviz.AbstractService;
import com.kviz.Category.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.Transaction;
import jakarta.transaction.TransactionManager;

import java.util.List;

public class AnswerService extends AbstractService<Answer> {

    EntityManager entityManager;

    public AnswerService() {
        super(Answer.class);
    }

    @Override
    protected EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
        return entityManager;
    }

   public List<Answer> findByCategory(Category category) {
        EntityManager em = entityManager();
        Query query = em.createNamedQuery("findByCategory");
        try {
            query.setParameter("category", category);
            List<Answer> answers = (List<Answer>) query.getResultList();
            return answers.isEmpty() ? null : answers;

        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }


    }


}
