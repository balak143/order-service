package com.ms.login.controller;

import com.ms.login.exception.ExceptionResponse;
import com.ms.login.models.Order;
import com.ms.login.models.Product;
import com.ms.login.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/orders")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Order order)throws Exception {

            order.setOrderId(orderService.createOrder(order));
            return ResponseEntity.ok(order);


    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            orderService.createProduct(product);
            return ResponseEntity.ok("Product has been created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(
                    new Date(),
                    e.getMessage(),
                    "/products",
                    HttpStatus.BAD_REQUEST
            ));
        }
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping("/products")
    public ResponseEntity<?> getProducts(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(orderService.viewProducts());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(
                    new Date(),
                    e.getMessage(),
                    "/products",
                    HttpStatus.BAD_REQUEST
            ));
        }


    }


}