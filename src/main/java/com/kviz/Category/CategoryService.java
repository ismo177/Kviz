package com.kviz.Category;

import com.kviz.AbstractService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryService extends AbstractService<Category> {

    EntityManager entityManager;


    public CategoryService() {
        super(Category.class);
    }

    @Override
    protected EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
        return entityManager;
    }
}
