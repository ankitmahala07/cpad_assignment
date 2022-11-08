package com.cpad.assignment.controller;

import com.cpad.assignment.model.Cart;
import com.cpad.assignment.model.Medicine;
import com.cpad.assignment.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    //get medicines
    @GetMapping
    public ResponseEntity<List<Medicine>> getMedicines(){
        return ResponseEntity.ok(medicineService.getMedicines());
    }

    //search medicine using filterDTO
    @GetMapping("/{query}")
    public ResponseEntity<List<Medicine>> searchMedicine(@RequestParam("query") String query){
        return ResponseEntity.ok(medicineService.searchMedicine(query));
    }

    //get medicine details
    @GetMapping("/id/{id}")
    public ResponseEntity<Medicine> getMedicine(@RequestParam("id") String id) throws Exception {
        return ResponseEntity.ok(medicineService.getMedicine(id));
    }

    //add medicine to cart
    @GetMapping("/add/{id}/{count}")
    public ResponseEntity<Cart> addMedicine(@RequestParam("id") String id,
                                            @RequestParam("count") int count) throws Exception {

        return ResponseEntity.ok(medicineService.addMedicine(id, count));
    }

    //remove medicine from cart
    @GetMapping("/remove/{id}")
    public ResponseEntity<Cart> removeMedicine(@RequestParam("id") String id) throws Exception {
        return ResponseEntity.ok(medicineService.removeMedicine(id));
    }

    //increase medicine count in cart
    @GetMapping("/update/{count}/{medicineId}")
    public ResponseEntity<Cart> updateMedicineQuantity(@RequestParam("count") int count,
                                                       @RequestParam("medicineId") String medicineId) throws Exception {
        return ResponseEntity.ok(medicineService.updateMedicineQuantity(count, medicineId));
    }
}
