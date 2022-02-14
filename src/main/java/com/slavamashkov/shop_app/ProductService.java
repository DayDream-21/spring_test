package com.slavamashkov.shop_app;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component("productService")
public class ProductService {
    List<Product> productList;

    @PostConstruct
    public void addProducts() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Product #1", 10));
        productList.add(new Product(2, "Product #2", 20));
        productList.add(new Product(3, "Product #3", 30));
        productList.add(new Product(4, "Product #4", 40));
        productList.add(new Product(5, "Product #5", 50));
        productList.add(new Product(6, "Product #6", 60));
        productList.add(new Product(7, "Product #7", 70));
        productList.add(new Product(8, "Product #8", 80));
        productList.add(new Product(9, "Product #9", 90));
        productList.add(new Product(10, "Product #10", 100));
    }

    public void printAll() {
        productList.forEach(System.out::println);
    }

    public Product findByTitle(String title) throws NoSuchElementException {
        for (Product p : productList) {
            if (p.getTitle().equals(title)) {
                return p;
            }
        }

        throw new NoSuchElementException();
    }
}