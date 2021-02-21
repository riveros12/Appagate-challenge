package com.appagate.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@NoArgsConstructor
@Getter
@Setter
public class OperationRequestDTO {
    @NotBlank(message = "keyidentifier is mandatory")
    private String keyidentifier;
    @NotNull(message = "value is mandatory")
    @Digits(integer=10, fraction=10)
    private Double value;
}
