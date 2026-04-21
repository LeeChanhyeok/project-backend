package com.example.sample.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemRequest {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    private String description;

    @Min(value = 0, message = "가격은 0 이상이어야 합니다.")
    private int price;
}
