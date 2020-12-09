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

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    public AppUser(@Min(6) String name, @Email String email, @Min(6) String password, String phone, String address, boolean status, AppRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone;
        this.address = address;
        this.role = role;
    }
}
