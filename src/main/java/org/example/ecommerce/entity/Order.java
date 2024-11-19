
package org.example.ecommerce.entity;


import jakarta.persistence.*;

        import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name = "orders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String ref;
    private double price;
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

}
