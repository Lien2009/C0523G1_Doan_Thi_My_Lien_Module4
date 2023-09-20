package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> showAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public boolean create(Product product) {
        if (showAll().contains(product)) {
            return false;
        } else {
            entityManager.persist(product);
            return true;
        }
    }
    @Transactional
    @Override
    public void update(Product product) {
        try {
            Product productEntity = detail(product.getId());
            productEntity.setName(product.getName());
            productEntity.setPrice(product.getPrice());
            productEntity.setDescription(product.getDescription());
            productEntity.setCompany(product.getCompany());
            entityManager.merge(product);
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }
    @Transactional
    @Override
    public void delete(int id) {
        Product productEntity = detail(id);
        entityManager.remove(productEntity);
    }

    @Override
    public Product detail(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("from Product where name=:name", Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
