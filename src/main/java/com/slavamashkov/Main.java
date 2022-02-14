package com.slavamashkov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ShopConfig.class)) {

            ProductService productService = context.getBean("productService", ProductService.class);
            Cart cart = context.getBean("cart", Cart.class);
            OrderService orderService = context.getBean("orderService", OrderService.class);

            cart.add(productService.findByTitle("Product #1"));
            cart.add(productService.findByTitle("Product #2"));
            cart.add(productService.findByTitle("Product #3"));
            orderService.createOrderFromCurrentCart();
        }
    }
}
