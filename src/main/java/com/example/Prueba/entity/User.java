package com.example.Prueba.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditoria{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Name")
    private String nameUser;
    @Column(name = "Lastname")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Addres")
    private String addres;
    @Column(name = "Identification")
    private String identification;
    @Column(name = "UserName")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "TotalValue")
    private Float totalValue;
}
