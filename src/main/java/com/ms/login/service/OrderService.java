package com.ms.login.service;

import com.ms.login.exception.SneakyThrow;
import com.ms.login.models.Order;
import com.ms.login.models.Product;
import com.ms.login.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    public String createOrder(Order order) throws Exception{
        // validate
        order.getItems().forEach(item -> {

                    Optional<Product> productOptional = productRepository.findById(item.getProductId());
                    Product product = productOptional.get();
                    if (item.getQuantity() > product.getQty()) {
                        try {
                            throw new Exception(" Items are out of stock for now, we will notify once they are available.");
                        } catch (Exception e) {
                            SneakyThrow.exception(e);
                        }
                    }
                    item.setAmount(item.getPrice()*item.getQuantity());
                    product.setQty(product.getQty()-item.getQuantity());
                    productRepository.save(product);

                }


        );
        order.getItems().forEach(item ->
                order.setTotalAmount(order.getTotalAmount()+item.getAmount())
        );
        order.setOrderDate(new Date());

        return String.valueOf(Math.abs(new Random().nextInt()));



    }


    public int createProduct(Product product) throws Exception {

        return productRepository.save(product).getId();

    }


    public List<Product> viewProducts() throws Exception {

        return productRepository.findAll();

    }

}
