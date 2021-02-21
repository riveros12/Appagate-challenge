package com.appagate.business;


import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author oscarriveros
 */
public class UniqueIdentifierTest {

    private UniqueIdentifier uniqueIdentifier;

    private String resultId;

    @Test
    public void getUniqueIdentifierTest() {
        uniqueIdentifier = new UniqueIdentifier();
        this.resultId = uniqueIdentifier.getUniqueIdentifier();
        assertNotNull(this.resultId);
    }

    @Test
    public void getUniqueIdentifierOnlyResultTest() {
        uniqueIdentifier = new UniqueIdentifier();
        List<String> out = Arrays.asList(uniqueIdentifier.getUniqueIdentifier(),
                uniqueIdentifier.getUniqueIdentifier(),
                uniqueIdentifier.getUniqueIdentifier(),
                uniqueIdentifier.getUniqueIdentifier());
        Map<String, Long> currencies = out.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        currencies.forEach((key, value) ->
                assertTrue(value == 1));
    }
}
