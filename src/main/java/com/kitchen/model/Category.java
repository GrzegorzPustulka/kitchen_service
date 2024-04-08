package com.kitchen.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category extends Base{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Dish> dishes;
}