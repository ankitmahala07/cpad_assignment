package com.cpad.assignment.service;

import com.cpad.assignment.model.Cart;
import com.cpad.assignment.model.Transaction;

import java.util.List;

public interface OrderService {

    public Cart getCart() throws Exception;

    public double getCartPrice() throws Exception;

    public void placeOrder() throws Exception;

    public List<Transaction> getTransactions(int page, int size) throws Exception;

    public List<Transaction> reorderTransaction(String transactionId) throws Exception;

    public String getUserId() throws Exception;
}
