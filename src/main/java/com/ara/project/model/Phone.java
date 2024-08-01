package com.ara.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(schema = "Phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imageURL,Phone_Model,new_price,old_price,role;

    public Phone(String imageURL, String phone_Model, String new_price, String old_price, String role) {
        this.imageURL = imageURL;
        Phone_Model = phone_Model;
        this.new_price = new_price;
        this.old_price = old_price;
        this.role = role;
    }
    public Phone() {}
}
