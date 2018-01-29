package bd.paperround.service.deliveryapproach;

import bd.paperround.model.Street;
import java.util.List;

/**
 *
 * @author Bhadresh Desai
 */
public class DeliveryApproachTwo implements DeliveryApproach {

    public static final String NAME = "Approach Two";
    private final Street street;

    public DeliveryApproachTwo(Street street) {
        this.street = street;
    }

    @Override
    public List<Integer> getDeliveryOrder() {
        return street.getHouseNumbers();
    }

    @Override
    public String getApproachName() {
        return NAME;
    }

    @Override
    public int getNumberOfStreetCrossings() {
        int roadCrossings = 0;
        if (street.getHouseNumbers().size() > 0) {
            int prevHouseNumber = street.getHouseNumbers().get(0);
            for (Integer houseNumber : street.getHouseNumbers()) {
                if ((prevHouseNumber % 2) != (houseNumber % 2)) {
                    roadCrossings++;
                }
                prevHouseNumber = houseNumber;
            }
        }
        return roadCrossings;
    }
}
