package com.appagate.domain.service;


import com.appagate.controller.request.OperationRequestDTO;
import com.appagate.controller.request.ResultRequestDTO;

/**
 * @author oscarriveros
 */
public interface AppagateCalculateService {

    public String getApikey();

    public Boolean validateExistApiKey(String key);

    public void setOperator(OperationRequestDTO operationRequestDTO);

    public Double getResult(ResultRequestDTO resultRequestDTO);

}
