package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Coca", 10000, "New", "ABC"));
        productList.add(new Product(2, "Pepsi", 20000, "Old", "ABC"));
        productList.add(new Product(3, "Mirinda", 30000, "New", "EZ"));
        productList.add(new Product(4, "SevenUp", 15000, "Old", "EZ"));
        productList.add(new Product(5, "String", 5000, "New", "ABC"));
    }

    @Override
    public int findIndex(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public boolean create(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    @Override
    public void update(Product product) {
        int index = findIndex(product.getId());
        productList.set(index, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(findIndex(id));
    }

    @Override
    public Product detail(int id) {
        Product product = productList.get(findIndex(id));
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(name)){
                products.add(productList.get(i));
            }
            break;
        }
        return products;
    }
}
