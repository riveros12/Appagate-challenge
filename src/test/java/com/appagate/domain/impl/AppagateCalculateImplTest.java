package com.appagate.domain.impl;

import com.appagate.controller.request.OperationRequestDTO;
import com.appagate.controller.request.ResultRequestDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class AppagateCalculateImplTest {


    private AppagateCalculateImpl appagateCalculate;

    private OperationRequestDTO operationRequestDTO;

    private ResultRequestDTO resultRequestDTO;

    @Before
    public void getInstance(){
        appagateCalculate =new AppagateCalculateImpl();
        operationRequestDTO= new OperationRequestDTO();
        resultRequestDTO=new ResultRequestDTO();
    }

    @Test
    public void getApikeyTest(){
        assertNotNull(appagateCalculate.getApikey());
    }

    @Test
    public void validateExistApiKeyTest(){
        String apikey=appagateCalculate.getApikey();
        assertTrue(appagateCalculate.validateExistApiKey(apikey));
    }

    @Test
    public void setOperatorTest(){
        List<Double> list=new ArrayList<>();
        String apikey=appagateCalculate.getApikey();
        operationRequestDTO.setKeyidentifier(apikey);
        operationRequestDTO.setValue(3.6);
        appagateCalculate.setOperator(operationRequestDTO);

        //calculate sum
        resultRequestDTO.setOperator("SUM");
        resultRequestDTO.setKeyidentifier(apikey);
        Double result=appagateCalculate.getResult(resultRequestDTO);
        assertThat(result.doubleValue(),is(3.6));
    }

    @Test
    public void getResultTest(){
        List<Double> list=new ArrayList<>();
        String apikey=appagateCalculate.getApikey();
        operationRequestDTO.setKeyidentifier(apikey);
        operationRequestDTO.setValue(3.6);
        appagateCalculate.setOperator(operationRequestDTO);
        operationRequestDTO= new OperationRequestDTO();
        operationRequestDTO.setKeyidentifier(apikey);
        operationRequestDTO.setValue(3.0);
        appagateCalculate.setOperator(operationRequestDTO);
        operationRequestDTO= new OperationRequestDTO();
        operationRequestDTO.setKeyidentifier(apikey);
        operationRequestDTO.setValue(-3.0);
        appagateCalculate.setOperator(operationRequestDTO);
        //calculate sum
        resultRequestDTO.setOperator("SUM");
        resultRequestDTO.setKeyidentifier(apikey);
        Double result=appagateCalculate.getResult(resultRequestDTO);
        assertThat(result.doubleValue(),is(3.6));
    }
}
