package com.slavamashkov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orderService")
public class OrderService {
    Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void createOrderFromCurrentCart() {
        System.out.println("Your order");
        List<Product> products = cart.getCartProductList();
        products.forEach(System.out::println);
        int totalPrice = products.stream().mapToInt(Product::getCost).sum();
        System.out.printf("Total price: %d%n", totalPrice);
    }
}
