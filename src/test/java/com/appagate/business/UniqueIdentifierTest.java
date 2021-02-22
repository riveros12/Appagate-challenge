package com.appagate.business;


import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


import static com.appagate.business.UniqueIdentifier.uniqueIdentifier;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author oscarriveros
 */
public class UniqueIdentifierTest {



    private String resultId;

    @Test
    public void getUniqueIdentifierTest() {
        UniqueIdentifier uniqueIdentifier = UniqueIdentifier.getUniqueIdentifier();
        this.resultId = uniqueIdentifier.getUniqueIdentifierkey();
        assertNotNull(this.resultId);
    }

    @Test
    public void getUniqueIdentifierOnlyResultTest() {
        uniqueIdentifier = UniqueIdentifier.getUniqueIdentifier();
        List<String> out = Arrays.asList(uniqueIdentifier.getUniqueIdentifierkey(),
                uniqueIdentifier.getUniqueIdentifierkey(),
                uniqueIdentifier.getUniqueIdentifierkey(),
                uniqueIdentifier.getUniqueIdentifierkey());
        Map<String, Long> currencies = out.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        currencies.forEach((key, value) ->
                assertTrue(value == 1));
    }
}
