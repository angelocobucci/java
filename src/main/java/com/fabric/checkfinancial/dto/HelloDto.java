package com.fabric.checkfinancial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor(staticName = "of")
@ToString
public class HelloDto {

    private String message;
}
