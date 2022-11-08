package com.cpad.assignment.model;

import com.arangodb.springframework.annotation.Document;
import org.springframework.data.annotation.Id;
import com.cpad.assignment.dto.MedicineDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document("transactions")
public class Transaction {
    @Id
    public String id;

    public Date createdAt = new Date();

    public List<Medicine> medicines = new ArrayList();

    public String userId;

    public double amount;
}
