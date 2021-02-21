package com.appagate.business;

import com.appagate.constants.Constant;
import com.appagate.domain.exception.AppagateException;
import com.appagate.domain.exception.ErrorCode;

import java.util.List;

import static java.lang.Math.*;
/**
 * @author oscarriveros
 */
public class Processor {

    /**
     * calculate
     *
     * @param values
     * @param operator
     * @return
     */
    public static double calculate(List<Double> values, String operator) {
        final double[] result = {0};
        try {
            values.forEach((value) -> {
                switch (operator) {
                    case Constant.SUM:
                        result[0]=values.stream()
                                .mapToDouble(item -> item)
                                .sum();
                        break;
                    case Constant.SUBTRACTION:
                        Double element_one=0.0;
                        for(int i=0;i<values.size();i++){
                            if(i==0){
                                element_one= values.get(i);

                            }else if(i==1){
                                result[0]=element_one-(values.get(i));
                            }else{
                                if(i<values.size()){
                                    result[0]=result[0] - (values.get(i));
                                }
                            }
                        }
                        break;
                    case Constant.MULTIPLICATION:
                        result[0] = values.stream().reduce(1.0, (a, b) -> a * b);
                        break;
                    case Constant.DIVISION:
                        Double element_=0.0;
                        for(int i=0;i<values.size();i++){
                            if(i==0){
                                element_= values.get(i);

                            }else if(i==1){
                                result[0]=element_ / (values.get(i));
                            }else{
                                if(i<values.size()){
                                    result[0]=result[0] / (values.get(i));
                                }
                            }
                        }
                        break;
                }
            });
        } catch (Exception ex) {
            throw new AppagateException(ErrorCode.EXCEPTION_CALCULATE.getDescripcion(), ex, ErrorCode.EXCEPTION_CALCULATE);
        }
        return result[0];
    }

    /**
     * pow_
     *
     * @param values
     * @return
     */
    public static double pow_(List<Double> values) {
        double result = 0;
        int size = 0;
        try {
            if (values.size() > 0) {
                size = values.size();
                result = pow(2, size);
            }
        } catch (Exception ex) {
            throw new AppagateException(ErrorCode.EXCEPTION_CALCULATE.getDescripcion(), ex, ErrorCode.EXCEPTION_CALCULATE);
        }
        return result;

    }
}
