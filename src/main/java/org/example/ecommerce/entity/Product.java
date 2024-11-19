package org.example.ecommerce.entity;


import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Table(name = "product")
@Entity
@Data

public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    private String name;
    private double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @ManyToOne()
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
