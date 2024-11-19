package org.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer extends User {

    private String address;

    private String city;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Order> orders;



}
