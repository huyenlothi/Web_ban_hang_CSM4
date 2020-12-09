package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    @Column(unique = true)
    @Min(6)
    private String name;
    @Min(6)
    private String password;

    @Min(8)
    private String full_name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String phone_number;

    @NotNull
    private String address;


    @ManyToOne
    @JoinColumn(name = "roll_id")
    private AppRole role;

}
