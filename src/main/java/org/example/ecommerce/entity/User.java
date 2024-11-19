package org.example.ecommerce.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "users")
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;
    private double salary;
    private int phone;
    private int age;
    private String email;
    private String password;
}
