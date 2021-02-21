package com.appagate.business.service;

import java.util.List;
/**
 * @author oscarriveros
 */
public interface Operator {

    public Double sum(List<Double> values);

    public Double subtraction(List<Double> values);

    public Double multiplication(List<Double> values);

    public Double division(List<Double> values);

    public Double pow_(List<Double> values);
}
