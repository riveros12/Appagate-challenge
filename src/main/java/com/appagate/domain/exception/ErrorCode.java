package com.appagate.domain.exception;

/**
 * @author oscarriveros
 */
public enum ErrorCode {

    STATUS_Ok("200", "Succes"),

    STATUS_BAD("500", "Bad"),

    ERROR_GENERATED_APIKEY("9","Error generating api_key "),

    EXCEPTION_CALCULATE("10", "Error performing calculation "),

    ERROR_VALIDATION_API_KEY("11","Error validating api key");

    private String description;
    private String code;

    ErrorCode(String descripcion, String code) {
        this.description = description;
        this.code = code;
    }

    public String getDescripcion() {
        return description;
    }

    public String getCode() {
        return code;
    }

}
