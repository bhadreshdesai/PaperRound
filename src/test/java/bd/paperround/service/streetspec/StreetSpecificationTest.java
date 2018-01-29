package bd.paperround.service.streetspec;

import bd.paperround.model.Street;
import bd.paperround.service.deliveryapproach.DeliveryApproach;
import bd.paperround.service.deliveryapproach.DeliveryApproachFactory;
import static bd.paperround.service.deliveryapproach.DeliveryApproachFactory.DeliveryApproachType.APPROACH_TWO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bhadresh Desai
 */
public class StreetSpecificationTest {

    public StreetSpecificationTest() {
    }

    @Test
    public void InvalidFormatComma() {
        final String spec = "1,2";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFormatCommaSpace() {
        final String spec = "1, 2";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFormatNonNumeric() {
        final String spec = "1 2a 2b";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFileNotStartingWith1() {
        final String spec = "2 3 4";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFileStartingWithSpace() {
        final String spec = " 1 2 3 4";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFileDuplicateHouseNumbers() {
        final String spec = "1 2 3 3 4";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFileMissingHouseNumbers() {
        final String spec = "1 2 4 5 6 7 8";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFileHouseNumbersNotInOrder1() {
        final String spec = "1 8 7 6 5 4 3 2";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidFileHouseNumbersNotInOrder2() {
        final String spec = "1 3 5 6 4 2";
        boolean expResult = false;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void ValidFile1() {
        final String spec = "1";
        boolean expResult = true;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void ValidFileSequential() {
        final String spec = "1 2 3 4 5 6 7 8";
        boolean expResult = true;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    public void ValidFileNonSequential() {
        final String spec = "1 3 5 7 2 4 6 8";
        boolean expResult = true;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void ValidFileExtraOddNumbers() {
        final String spec = "1 2 3 4 5 6 7 8 9 11 13";
        boolean expResult = true;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void ValidFileExtraEvenNumbers() {
        final String spec = "1 2 3 4 5 6 7 8 10 12 14";
        boolean expResult = true;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void ValidFileNorthHousesOnly() {
        final String spec = "1 3 5";
        boolean expResult = true;
        boolean result = getStreet(spec).isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void InvalidStreetDeliveryApproach() {
        DeliveryApproach approach = DeliveryApproachFactory.createDeliveryApproach(APPROACH_TWO, getStreet("1 2 3 5 4  10"));
        List<Integer> d = approach.getDeliveryOrder();
    }

    private Street getStreet(String streetSpec) {
        return new StreetSpecification(streetSpec).getStreet();
    }
}
