package com.example.Prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    //@JsonProperty("name")
    private String name;

    //@JsonProperty("lastname")
    private String lastName;

    //@JsonProperty("username")
    private String username;

    //@JsonProperty("password")
    private String password;

    //@JsonProperty("email")
    private String email;

    //@JsonProperty("phone")
    private String phone;

    //@JsonProperty("addres")
    private String addres;

    //@JsonProperty("identification")
    private String identification;

    //@JsonProperty("totalValue")
    private Float totalValue;
}
