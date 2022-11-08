package com.cpad.assignment.service;

import com.cpad.assignment.model.Cart;
import com.cpad.assignment.model.Medicine;

import java.util.List;

public interface MedicineService {

    public List<Medicine> getMedicines();

    public List<Medicine> searchMedicine(String query);

    public Medicine getMedicine(String id) throws Exception;

    public Cart addMedicine(String id, int Count) throws Exception;

    public Cart removeMedicine(String id) throws Exception;

    public Cart updateMedicineQuantity(int count, String id) throws Exception;

}
