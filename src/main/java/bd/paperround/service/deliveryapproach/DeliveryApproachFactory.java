package bd.paperround.service.deliveryapproach;

import bd.paperround.model.Street;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Bhadresh Desai
 */
public class DeliveryApproachFactory {

    @RequiredArgsConstructor
    @Getter(AccessLevel.PRIVATE)
    public static enum DeliveryApproachType {
        APPROACH_ONE((street) -> new DeliveryApproachOne(street)),
        APPROACH_TWO((street) -> new DeliveryApproachTwo(street));

        private final DeliveryApproachConstructor constructor;
    }

    @FunctionalInterface
    private interface DeliveryApproachConstructor {

        DeliveryApproach create(Street street);
    }

    public static DeliveryApproach createDeliveryApproach(DeliveryApproachType type, Street street) {
        return type.getConstructor().create(street);
    }

    private DeliveryApproachFactory() {

    }
}
