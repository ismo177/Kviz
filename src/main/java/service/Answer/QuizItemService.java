package service.Answer;


import service.AbstractService;
import service.Category.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class QuizItemService extends AbstractService<QuizItem> {

    EntityManager entityManager;

    public QuizItemService() {
        super(QuizItem.class);
    }

    @Override
    protected EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
        return entityManager;
    }

   public List<QuizItem> findByCategory(Category category) {
        EntityManager em = entityManager();
        Query query = em.createNamedQuery("findByCategory");
        try {
            query.setParameter("category", category);
            List<QuizItem> quizItems = (List<QuizItem>) query.getResultList();
            return quizItems.isEmpty() ? null : quizItems;

        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }


    }


}
