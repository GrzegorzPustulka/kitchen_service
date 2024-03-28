package com.kitchen.controller;

import org.springframework.stereotype.Component;

@Component
public class ChickenOrder implements Order{
    @Override
    public String receiveOrder() {
        return "Chicken order received!";
    }
}
