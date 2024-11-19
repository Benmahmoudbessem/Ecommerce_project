package org.example.ecommerce.entity;


import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Table(name = "category")
@Entity
@Data

public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)

    private List<Subcategory> subcategories;

}
