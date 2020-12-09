package com.around.soh.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloResponseDtoTest {

    @Test
    public void lombok_test() {
        String name="test";
        int amount =1000;

        HelloResponseDto dto=new HelloResponseDto(name,amount);


        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(1000);

    }
}