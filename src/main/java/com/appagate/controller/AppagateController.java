package com.appagate.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author oscarriveros
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/appagate")
public class AppagateController {


    @RequestMapping(value = "/newappid", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> getNewAppId() {
            return new ResponseEntity<>("new id app", HttpStatus.OK);
    }

    @RequestMapping(value = "/app/id", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> getInformationTransmitter() {
        return new ResponseEntity<>("app_id", HttpStatus.OK);
    }


    @RequestMapping(value = "/operation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> setOperation() {
        return new ResponseEntity<>("operation", HttpStatus.OK);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<String> getResult() {
        return new ResponseEntity<>("reult", HttpStatus.OK);
    }

}
