package com.cpad.assignment.model;

import com.arangodb.springframework.annotation.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document("medicines")
public class Medicine {
    @Id
    public String id;

    public Date createdAt = new Date();

    public String name;

    public String description;

    public String price;

    public Boolean prescriptionRequired;

    public int quantity;
}
