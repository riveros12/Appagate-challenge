package com.appagate.controller.validator.request;


import com.appagate.domain.exception.AppagateException;
import com.appagate.domain.exception.ErrorCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorValidator {

    /**
     * validacionErrorApp
     * @param errors
     * @throws AppagateException
     */
    public static void validationionErrorApp (BindingResult errors) throws AppagateException {
        if ( errors.hasErrors() ){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ErrorCode.STATUS_BAD.getDescripcion());
            for (ObjectError error :errors.getAllErrors()){
                stringBuilder.append("\n" + error.getDefaultMessage());
            }throw  new AppagateException(stringBuilder.toString(), new IllegalArgumentException("Bad arguments to start service"), ErrorCode.STATUS_BAD );}}

}
