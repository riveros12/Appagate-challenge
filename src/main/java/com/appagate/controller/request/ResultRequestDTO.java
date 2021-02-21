package com.appagate.controller.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class ResultRequestDTO {
    @NotBlank(message = "keyidentifier is mandatory")
    private String keyidentifier;
    @NotBlank(message = "operator is mandatory")
    private String operator;
}
