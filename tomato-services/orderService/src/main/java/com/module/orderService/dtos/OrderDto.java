package com.module.orderService.dtos;

public class OrderDto {
    private final int id;
    private final int customerId;
    private final String name;

    public OrderDto(final int id, final int customerId, final String name) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
