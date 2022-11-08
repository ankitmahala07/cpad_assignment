package com.cpad.assignment.controller;

import com.cpad.assignment.model.Cart;
import com.cpad.assignment.model.Medicine;
import com.cpad.assignment.model.Transaction;
import com.cpad.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    //get cart
    @GetMapping("/cart")
    public ResponseEntity<Cart> getCart() throws Exception {
        return ResponseEntity.ok(orderService.getCart());
    }

    //place order on cart
    @PostMapping("/order")
    public void placeOrder(
            @RequestBody Cart items
    ) throws Exception {
        orderService.placeOrder(items);
    }

    //get transactions
    @GetMapping("/transactions/{page}/{size}")
    public ResponseEntity<List<Transaction>> getTransactions(
            @RequestParam int page,
            @RequestParam int size
    ) throws Exception{
        return ResponseEntity.ok(orderService.getTransactions(page, size));
    }

    //reorder a transaction
    @GetMapping("/transactions/refill/{transactionId}")
    public ResponseEntity<List<Transaction>>
    reorderTransaction(@RequestParam String transactionId) throws Exception{
        return ResponseEntity.ok(orderService.reorderTransaction(transactionId));
    }

}
