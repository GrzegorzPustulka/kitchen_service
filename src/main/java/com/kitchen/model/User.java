//package com.kitchen.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name="user")
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private int id;
//
//    @Column(name="email")
//    private String email;
//
//    @Column(name="password")
//    private String password;
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//}
