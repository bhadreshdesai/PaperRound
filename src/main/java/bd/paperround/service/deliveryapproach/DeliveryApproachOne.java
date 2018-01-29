package bd.paperround.service.deliveryapproach;

import bd.paperround.model.Street;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Bhadresh Desai
 */
public class DeliveryApproachOne implements DeliveryApproach {

    public static final String NAME = "Approach One";
    private final Street street;

    public DeliveryApproachOne(Street street) {
        this.street = street;
    }

    @Override
    public List<Integer> getDeliveryOrder() {
        List<Integer> northHouseNumbers = this.street.getNorthHouseNumbers();
        List<Integer> southHouseNumbers = this.street.getSouthHouseNumbers();
        Collections.reverse(southHouseNumbers);
        return Stream.concat(northHouseNumbers.stream(), southHouseNumbers.stream()).collect(Collectors.toList());
    }

    @Override
    public String getApproachName() {
        return NAME;
    }

    @Override
    public int getNumberOfStreetCrossings() {
        // Assumption: Delivery person always starts on the north side even if there are no houses on the north side.
        // If there are no houses on the south side the delivery person will not cross the street.
        return (this.street.getSouthHouseNumbers().isEmpty()) ? 0 : 1;
    }

}
