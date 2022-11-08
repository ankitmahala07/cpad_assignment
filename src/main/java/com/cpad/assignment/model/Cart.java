package com.cpad.assignment.model;

import com.arangodb.springframework.annotation.Document;
import com.cpad.assignment.dto.MedicineDTO;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document("cart")
public class Cart {
    @Id
    public String id;

    public Date createdAt = new Date();

    public String userId;

    public List<Medicine> medicines = new ArrayList();
}
