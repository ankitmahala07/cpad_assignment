package com.cpad.assignment.dto;

import lombok.Data;

@Data
public class MedicineDTO {

    private String medicineId = null;

    private String medicineName = null;

    private Boolean prescriptionRequired = false;

    private int quantity = 1;

    private float amount = 0.0f;

    private String prescriptionFileName = null;

}
