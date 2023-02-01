package com.example.SpringBootRedis_demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
}
