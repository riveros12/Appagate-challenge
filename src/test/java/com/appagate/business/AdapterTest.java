package com.appagate.business;

import com.appagate.business.impl.Adapter;
import com.appagate.business.service.Operator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


/**
 * @author oscarriveros
 */
public class AdapterTest {

    private List<Double> values= Arrays.asList(1.2,3.5,-3.3,-1.0);

    private Operator operator;

    @Test
    public void sumTest(){
        operator=new Adapter();
        assertNotNull(operator.sum(values));
        assertEquals(operator.sum(values),0.40000000000000036);
    }

    @Test
    public void subtractionTest(){
        operator=new Adapter();
        assertNotNull(operator.subtraction(values));
        assertEquals(operator.subtraction(values),2.0);
    }

    @Test
    public void multiplicationTest(){
        operator=new Adapter();
        assertNotNull(operator.multiplication(values));
        assertEquals(operator.multiplication(values),13.86);
    }

    @Test
    public void divisionTest(){
        operator=new Adapter();
        assertNotNull(operator.division(values));
        assertEquals(operator.division(values),0.1038961038961039);
    }

    @Test
    public void pow_Test(){
        operator=new Adapter();
        assertNotNull(operator.pow_(values));
        assertEquals(operator.pow_(values),16.0);
    }
}
