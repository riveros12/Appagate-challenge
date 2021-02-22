package com.appagate.domain.impl;

import com.appagate.business.UniqueIdentifier;
import com.appagate.business.impl.Adapter;
import com.appagate.business.service.Operator;
import com.appagate.constants.Constant;
import com.appagate.controller.request.OperationRequestDTO;
import com.appagate.controller.request.ResultRequestDTO;
import com.appagate.domain.exception.AppagateException;
import com.appagate.domain.exception.ErrorCode;
import com.appagate.domain.service.AppagateCalculateService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@Getter
@Setter
public class AppagateCalculateImpl implements AppagateCalculateService {

    private UniqueIdentifier identifier;

    private Operator operator;

    private HashMap<String, List<Double>> data;

    AppagateCalculateImpl(){
        identifier= UniqueIdentifier.getUniqueIdentifier();
        operator= new Adapter();
        data=new HashMap<>();
    }


    @Override
    public String getApikey() {
        String apiKey="";
        List<Double> listValuesOpera=new ArrayList<>();
        try{
            apiKey=this.identifier.getUniqueIdentifierkey();
            this.data.put(apiKey,listValuesOpera);
        }catch (Exception ex){
            throw new AppagateException(ErrorCode.ERROR_GENERATED_APIKEY.getDescripcion(), ex, ErrorCode.ERROR_GENERATED_APIKEY);
        }
        return apiKey;
    }

    @Override
    public Boolean validateExistApiKey(String key) {
        try{
            if(this.data.containsKey(key)){
                return true;
            }else{
                return false;
            }
        }catch (Exception ex){
            throw new AppagateException(ErrorCode.ERROR_VALIDATION_API_KEY.getDescripcion(), ex, ErrorCode.ERROR_VALIDATION_API_KEY);
        }
    }

    @Override
    public void setOperator(OperationRequestDTO operationRequestDTO) {
        try{
            if(this.data.containsKey(operationRequestDTO.getKeyidentifier())){
                this.data.get(operationRequestDTO.getKeyidentifier()).add(operationRequestDTO.getValue());
            }
        }catch (Exception ex){
            throw new AppagateException(ErrorCode.ERROR_VALIDATION_API_KEY.getDescripcion(), ex, ErrorCode.ERROR_VALIDATION_API_KEY);
        }
    }

    @Override
    public Double getResult(ResultRequestDTO resultRequestDTO) {
        List<Double> valuesToEvaluate=null;
        Double result=0.0;
        try{
            switch (resultRequestDTO.getOperator().toUpperCase()){
                case Constant.SUM:
                    valuesToEvaluate=this.data.get(resultRequestDTO.getKeyidentifier());
                    result=this.operator.sum(valuesToEvaluate);
                    break;
                case Constant.SUBTRACTION:
                    valuesToEvaluate=this.data.get(resultRequestDTO.getKeyidentifier());
                    result=this.operator.subtraction(valuesToEvaluate);
                    break;
                case Constant.MULTIPLICATION:
                    valuesToEvaluate=this.data.get(resultRequestDTO.getKeyidentifier());
                    result=this.operator.multiplication(valuesToEvaluate);
                    break;
                case Constant.DIVISION:
                    valuesToEvaluate=this.data.get(resultRequestDTO.getKeyidentifier());
                    result=this.operator.division(valuesToEvaluate);
                    break;
                case Constant.POW:
                    valuesToEvaluate=this.data.get(resultRequestDTO.getKeyidentifier());
                    result=this.operator.pow_(valuesToEvaluate);
                    break;
            }
        }catch (Exception ex){
            throw new AppagateException(ErrorCode.ERROR_VALIDATION_API_KEY.getDescripcion(), ex, ErrorCode.ERROR_VALIDATION_API_KEY);
        }
        return result;
    }
}
