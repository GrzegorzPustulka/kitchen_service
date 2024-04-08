package com.kitchen.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@NoArgsConstructor
public class Recipe extends Base {

    @Column(name = "steps")
    private String steps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;
}