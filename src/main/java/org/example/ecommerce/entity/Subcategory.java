package org.example.ecommerce.entity;


import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Table(name = "subcategory")
@Entity
@Data

public class Subcategory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private int id;
    private String title;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    private List<Product> products;


}
