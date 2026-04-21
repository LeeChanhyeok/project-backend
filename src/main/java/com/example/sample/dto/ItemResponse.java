package com.example.sample.dto;

import com.example.sample.domain.Item;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ItemResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final int price;
    private final LocalDateTime createdAt;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.createdAt = item.getCreatedAt();
    }
}
