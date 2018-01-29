package bd.paperround.model;

import bd.paperround.utils.ListUtils;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bhadresh Desai
 */
@Getter
@Setter
public class Street {

    private List<Integer> houseNumbers = Collections.<Integer>emptyList();          // All house numbers on the street

    private boolean isValid = false;

    public List<Integer> getNorthHouseNumbers() {
        // Houses in north are odd numbered
        return ListUtils.getOddNumbers(houseNumbers);
    }

    public List<Integer> getSouthHouseNumbers() {
        // Houses in south are even numbered
        return ListUtils.getEvenNumbers(houseNumbers);
    }

}
