package com.example.kicktheworld_test.Cart.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    @NotNull(message = "숙소아이디는 필수 입력 값입니다.")
    private Long stay_id;

    @Min(value = 1, message = "최소 숙박일은 1일 입니다.")
    @Max(value = 10, message = "최대 숙박일수는 10일 입니다.")
    private int count;

}