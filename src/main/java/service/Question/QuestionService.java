package service.Question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.AbstractService;

public class QuestionService extends AbstractService<Question> {
    EntityManager entityManager;

    public QuestionService() {
        super(Question.class);
    }

    @Override
    protected EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
        return entityManager;
    }
}
