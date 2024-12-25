package com.module.customerService.dtos;

public class CustomerDto {
    private final int id;
    private final String name;
    private final String email;

    public CustomerDto(final int id,  final String name,final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {return email;}
}
