package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    private Integer quantity;

    private Long price;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Products products;

    @ManyToOne
    @JoinColumn(name="bill_id")
    private Bill bill;

}
