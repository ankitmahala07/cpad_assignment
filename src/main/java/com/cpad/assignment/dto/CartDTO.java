package com.cpad.assignment.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO {

    private String cartId;

    public String userId;

    private List<MedicineDTO> medicines = new ArrayList();

    private List<String> prescriptionFileName  = new ArrayList();

}
