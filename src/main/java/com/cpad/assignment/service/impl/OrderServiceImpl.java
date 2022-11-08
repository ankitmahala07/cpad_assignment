package com.cpad.assignment.service.impl;

import com.cpad.assignment.dto.MedicineDTO;
import com.cpad.assignment.model.Cart;
import com.cpad.assignment.model.Medicine;
import com.cpad.assignment.model.Transaction;
import com.cpad.assignment.repository.CartRepository;
import com.cpad.assignment.repository.TransactionRepository;
import com.cpad.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private TransactionRepository transactionRepository;

    public Cart getCart() throws Exception{
        Optional<Cart> cart = cartRepository.findByUserId(getUserId());
        if(!cart.isPresent()) {
            Cart crt = new Cart();
            crt.userId = getUserId();
            cart = Optional.of(cartRepository.save(crt));
        }
        return cart.get();
    }

    public double getCartPrice() throws Exception {
        Cart cart = cartRepository.findByUserId(getUserId()).get();
        double totalPrice = 0;
        for(var med : cart.medicines){
            totalPrice += (med.quantity * Float.parseFloat(med.price));
        }
        return totalPrice;
    }

    public void placeOrder() throws Exception{
        Optional<Cart> cart = cartRepository.findByUserId(getUserId());
        if(!cart.isPresent()) {
            throw new Exception("No cart found");
        }
        if(cart.get().medicines.isEmpty()){
            return;
        }

        Transaction trans = new Transaction();
        trans.userId = getUserId();
        trans.medicines = cart.get().medicines;

        cart.get().medicines.forEach(it -> {
            trans.amount += (Float.parseFloat(it.price) * it.quantity);
        });

        transactionRepository.save(trans);

        cart.get().medicines = new ArrayList<>();
        cartRepository.save(cart.get());
    }

    public List<Transaction> getTransactions(int page, int size) throws Exception{
        List<Transaction> transactions = transactionRepository.findByUserIdAndPageAndSize(getUserId(), page*size, size);
        return transactions;
    }

    public List<Transaction> reorderTransaction(String transactionId) throws Exception{
        Transaction transaction = transactionRepository.findById(transactionId).get();
        transaction.id = null;
        transaction.createdAt = new Date();
        transactionRepository.save(transaction);
        List<Transaction> transactions = transactionRepository.findByUserIdAndPageAndSize(getUserId(), 0, 3);
        return transactions;
    }

    public String getUserId() throws Exception {
        String userId = httpServletRequest.getHeader("USER_ID");
        if(userId == null || userId.isEmpty()){
            throw new Exception("No user id found");
        }
        return userId;
    }
}
