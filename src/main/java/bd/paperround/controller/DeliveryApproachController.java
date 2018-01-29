package bd.paperround.controller;

import bd.paperround.service.deliveryapproach.DeliveryApproach;
import bd.paperround.service.deliveryapproach.DeliveryApproachFactory;
import static bd.paperround.service.deliveryapproach.DeliveryApproachFactory.DeliveryApproachType.*;
import bd.paperround.service.streetspec.StreetSpecification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bhadresh Desai
 */
@RestController
public class DeliveryApproachController {

    @RequestMapping(value = "/deliveryapproachone", method = RequestMethod.POST)
    public DeliveryApproach deliveryApproachOne(@RequestParam(value = "streetSpec") String streetSpec) {
        return DeliveryApproachFactory.createDeliveryApproach(APPROACH_ONE, new StreetSpecification(streetSpec).getStreet());
    }

    @RequestMapping(value = "/deliveryapproachtwo", method = RequestMethod.POST)
    public DeliveryApproach deliveryApproachTwo(@RequestParam(value = "streetSpec") String streetSpec) {
        return DeliveryApproachFactory.createDeliveryApproach(APPROACH_TWO, new StreetSpecification(streetSpec).getStreet());
    }
}
