package org.example.ecommerce.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor

public class Provider extends User {

    private String matricule;

    private String service;
    private String company;

    @OneToMany(mappedBy = "provider",cascade = CascadeType.ALL)

    private List<Product> products;
}
