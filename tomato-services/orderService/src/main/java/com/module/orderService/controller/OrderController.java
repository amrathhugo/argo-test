package com.module.orderService.controller;

import com.module.orderService.dtos.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class OrderController {
    private final List<OrderDto> OrderDtos = Arrays.asList(
            new OrderDto(1, 1, "Product A"),
            new OrderDto(2, 1, "Product B"),
            new OrderDto(3, 2, "Product C"),
            new OrderDto(4, 1, "Product D"),
            new OrderDto(5, 2, "Product E"));

    @GetMapping("/getOrders")
    public List<OrderDto> getAllOrderDtos() {
        return OrderDtos;
    }

    @GetMapping("/getOrder/{id}")
    public OrderDto getOrderDtoById(@PathVariable int id) {
        return OrderDtos.stream()
                .filter(OrderDto -> OrderDto.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
