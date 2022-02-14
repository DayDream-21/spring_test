package com.slavamashkov.shop_app;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component("cart")
public class Cart {
    List<Product> cartProductList;

    @PostConstruct
    public void init() {
        cartProductList = new ArrayList<>();
    }

    public void add(Product product) {
        cartProductList.add(product);
    }
}
