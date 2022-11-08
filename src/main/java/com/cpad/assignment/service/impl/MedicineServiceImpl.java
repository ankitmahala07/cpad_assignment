package com.cpad.assignment.service.impl;

import com.cpad.assignment.model.Cart;
import com.cpad.assignment.model.Medicine;
import com.cpad.assignment.repository.CartRepository;
import com.cpad.assignment.repository.MedicineRepository;
import com.cpad.assignment.service.MedicineService;
import com.cpad.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartRepository cartRepository;

    public List<Medicine> getMedicines(){
        List<Medicine> meds = new ArrayList<>();
        Iterable<Medicine> list = medicineRepository.findAll();
        list.forEach(it -> {
            meds.add(it);
        });
        return meds;
    }

    public List<Medicine> searchMedicine(String query){
        return medicineRepository.searchMedicines(query);
    }

    public Medicine getMedicine(String id) throws Exception {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isPresent()){
            return medicine.get();
        }
        throw new Exception("Medicine id incorrect");
    }

    public Cart addMedicine(String id, int Count) throws Exception {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isPresent()){
            int oldCount = 0;
            Cart cart = cartRepository.findByUserId(orderService.getUserId()).get();
            boolean medPresent = false;
            for(var med: cart.medicines){
                if(med.id.equals(id)){
                    medPresent = true;
                    oldCount = med.quantity;
                    cart.medicines.remove(med);
                    break;
                }
            }

            medicine.get().quantity = oldCount + Count;
            cart.medicines.add(medicine.get());
            cartRepository.save(cart);

            return cart;
        }
        throw new Exception("Medicine id incorrect");
    }

    public Cart removeMedicine(String id) throws Exception {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isPresent()){
            Cart cart = cartRepository.findByUserId(orderService.getUserId()).get();
            Medicine toBeRemoved = null;
            for(var med : cart.medicines){
                if(med.id.equals(medicine.get().id)){
                    toBeRemoved = med;
                }
            }
            cart.medicines.remove(toBeRemoved);
            return cartRepository.save(cart);
        }
        throw new Exception("Medicine id incorrect");
    }

    public Cart updateMedicineQuantity(int count, String id) throws Exception {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isPresent()){
            Cart cart = cartRepository.findByUserId(orderService.getUserId()).get();
            for(var med: cart.medicines){
                if(med.id.equals(id)){
                    med.quantity = Math.max(count, 0);
                }
            }
            cartRepository.save(cart);
            return cart;
        }
        throw new Exception("Medicine id incorrect");
    }
}
