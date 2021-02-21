package com.appagate.controller;


import com.appagate.controller.request.OperationRequestDTO;
import com.appagate.controller.request.ResultRequestDTO;
import com.appagate.controller.validator.request.ErrorValidator;
import com.appagate.domain.exception.AppagateException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

/**
 * @author oscarriveros
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/appagate")
public class AppagateController {


    /**
     *
     * @return
     */
    @RequestMapping(value = "/newappid", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> getNewAppId() {
            return new ResponseEntity<>("new id app", HttpStatus.OK);
    }


    /**
     *
     * @param operationRequestDTO
     * @param error
     * @return
     */
    @RequestMapping(value = "/add/value", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<Integer> setValue(@RequestBody @Valid OperationRequestDTO operationRequestDTO, BindingResult error) {
        try{
            ErrorValidator.validationionErrorApp(error);

            return new ResponseEntity<>(300, HttpStatus.OK);
        }catch(AppagateException ex){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    /**
     *
     * @param resultRequestDTO
     * @param error
     * @return
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> getResult(@RequestBody @Valid ResultRequestDTO resultRequestDTO, BindingResult error) {
        try{
            ErrorValidator.validationionErrorApp(error);
            return new ResponseEntity<>("result", HttpStatus.OK);
        }catch(AppagateException ex){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

}
