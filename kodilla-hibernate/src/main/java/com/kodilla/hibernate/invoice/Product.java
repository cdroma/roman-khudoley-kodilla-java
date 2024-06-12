package com.kodilla.hibernate.invoice;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
