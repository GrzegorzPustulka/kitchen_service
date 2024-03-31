package com.kitchen.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class Base {

    @Id
    @GeneratedValue(generator = "uuid4")
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;

}

