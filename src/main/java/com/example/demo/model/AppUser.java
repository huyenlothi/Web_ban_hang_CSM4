package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
@Table(name = "users")
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
    @Email
    private String email;
    @Min(6)
    private String password;
    @NotNull
    private String phone;
    @NotNull
    private String address;

    @Column(columnDefinition = "bit default true")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "roles_id")
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
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.role = role;
    }
}
