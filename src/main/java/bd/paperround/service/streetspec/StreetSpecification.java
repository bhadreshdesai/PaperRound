package bd.paperround.service.streetspec;

import bd.paperround.model.Street;
import bd.paperround.utils.ListUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Bhadresh Desai
 */
public class StreetSpecification {

    private final Street street = new Street();
    private final String streetSpec;

    public StreetSpecification(String streetSpec) {
        this.streetSpec = streetSpec;
        parseStreetSpec();
    }

    public Street getStreet() {
        return this.street;
    }

    private boolean hasNoMissingHouseNumbers(List<Integer> houseNumbers) {
        List<Integer> northHouseNumbers = ListUtils.getOddNumbers(houseNumbers);
        List<Integer> southHouseNumbers = ListUtils.getEvenNumbers(houseNumbers);
        int nsize, nlast = 0, ssize, slast = 0;
        nsize = northHouseNumbers.size();
        if (nsize > 0) {
            nlast = northHouseNumbers.get(nsize - 1);
        }

        ssize = southHouseNumbers.size();
        if (ssize > 0) {
            slast = southHouseNumbers.get(ssize - 1);
        }
        return ((nsize == 0) || (nsize == (nlast + 1) / 2))
                && ((ssize == 0) || (ssize == slast / 2));
    }

    private boolean hasUniqueHouseNumbers(List<Integer> houseNumbers) {
        return ListUtils.isUnique(houseNumbers);
    }

    private boolean houseNumbersInOrder(List<Integer> houseNumbers) {
        List<Integer> northHouseNumbers = ListUtils.getOddNumbers(houseNumbers);
        List<Integer> southHouseNumbers = ListUtils.getEvenNumbers(houseNumbers);
        return (ListUtils.isOrderedList(northHouseNumbers)
                && ListUtils.isOrderedList(southHouseNumbers));
    }

    private void parseStreetSpec() {
        try {
            // Assumption: Stree specification is space separated
            List<Integer> houseNumbers = Stream.of(this.streetSpec.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            boolean valid = startsWith1(houseNumbers)
                    && hasUniqueHouseNumbers(houseNumbers)
                    && houseNumbersInOrder(houseNumbers)
                    && hasNoMissingHouseNumbers(houseNumbers);
            street.setValid(valid);
            if (valid) {
                street.setHouseNumbers(houseNumbers);
            }
        } catch (NumberFormatException nfe) {
            // Assumption: Street specification contains numbers only
        }
    }

    private boolean startsWith1(List<Integer> houseNumbers) {
        return houseNumbers.get(0) == 1;
    }

}
