package com.appagate.controller;


import com.appagate.controller.request.OperationRequestDTO;
import com.appagate.controller.request.ResultRequestDTO;
import com.appagate.controller.validator.request.ErrorValidator;
import com.appagate.domain.exception.AppagateException;
import com.appagate.domain.impl.AppagateCalculateImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AppagateCalculateImpl appagateCalculate;


    /**
     *
     * @return
     */
    @RequestMapping(value = "/newappid", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> getNewAppId() {
        return new ResponseEntity<>(appagateCalculate.getApikey(), HttpStatus.OK);
    }


    /**
     *
     * @param operationRequestDTO
     * @param error
     * @return
     */
    @RequestMapping(value = "/add/value", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> setValue(@RequestBody @Valid OperationRequestDTO operationRequestDTO, BindingResult error) {
        try{
            ErrorValidator.validationionErrorApp(error);
            if(!this.appagateCalculate.validateExistApiKey(operationRequestDTO.getKeyidentifier())){
                return new ResponseEntity<>("Invalid identifier ", HttpStatus.OK);
            }else{
                this.appagateCalculate.setOperator(operationRequestDTO);
                return new ResponseEntity<>("Succes", HttpStatus.OK);
            }
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
    ResponseEntity<Double> getResult(@RequestBody @Valid ResultRequestDTO resultRequestDTO, BindingResult error) {
        try{
            Double result=0.0;
            ErrorValidator.validationionErrorApp(error);
            if(!this.appagateCalculate.validateExistApiKey(resultRequestDTO.getKeyidentifier())){
                return new ResponseEntity<>(400.0, HttpStatus.BAD_REQUEST);
            }else{
                result=this.appagateCalculate.getResult(resultRequestDTO);
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        }catch(AppagateException ex){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

}
