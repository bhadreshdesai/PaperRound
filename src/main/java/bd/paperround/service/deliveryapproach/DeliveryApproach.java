package bd.paperround.service.deliveryapproach;

import java.util.List;

/**
 *
 * @author Bhadresh Desai
 */
public interface DeliveryApproach {

    List<Integer> getDeliveryOrder();

    String getApproachName();

    int getNumberOfStreetCrossings();
}
