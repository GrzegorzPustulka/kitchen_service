package com.kitchen.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "dishes")
@Getter
@Setter
@NoArgsConstructor
public class Dish extends Base{
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
