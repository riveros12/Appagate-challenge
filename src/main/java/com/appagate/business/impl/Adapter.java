package com.appagate.business.impl;

import com.appagate.business.Processor;
import com.appagate.business.service.Operator;
import com.appagate.constants.Constant;

import java.util.List;
/**
 * @author oscarriveros
 */
public class Adapter implements Operator {
    @Override
    public Double sum(List<Double> values) {
        return Processor.calculate(values, Constant.SUM);
    }

    @Override
    public Double subtraction(List<Double> values) {
        return Processor.calculate(values,Constant.SUBTRACTION);
    }

    @Override
    public Double multiplication(List<Double> values) {
        return Processor.calculate(values,Constant.MULTIPLICATION);
    }

    @Override
    public Double division(List<Double> values) {
        return Processor.calculate(values,Constant.DIVISION);
    }

    @Override
    public Double pow_(List<Double> values) {
        return Processor.pow_(values);
    }
}
