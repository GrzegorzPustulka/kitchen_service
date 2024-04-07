package com.kitchen.service;

import com.kitchen.dto.OrderStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OrderStatusService {

    private final WebClient webClient;

    @Autowired
    public OrderStatusService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Void> sendNewOrderStatus(OrderStatusRequest orderStatusRequest) {
        return webClient.post()
                .uri("/")
                .bodyValue(orderStatusRequest)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(aVoid -> System.out.println("Status zamówienia został pomyślnie wysłany."))
                .doOnError(error -> System.err.println("Wystąpił błąd podczas wysyłania statusu zamówienia: " + error.getMessage()));
    }
}