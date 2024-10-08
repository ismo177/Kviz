package service.UserScore;

import service.AbstractService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserScoreService extends AbstractService<UserScore> {

    EntityManager entityManager;

    public UserScoreService() {
        super(UserScore.class);
    }

    @Override
    protected EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
        return entityManager;
    }

}
