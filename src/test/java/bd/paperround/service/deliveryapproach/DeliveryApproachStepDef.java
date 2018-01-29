package bd.paperround.service.deliveryapproach;

import bd.paperround.service.streetspec.StreetSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;

import static bd.paperround.service.deliveryapproach.DeliveryApproachFactory.DeliveryApproachType.*;

/**
 *
 * @author Bhadresh Desai
 */
public class DeliveryApproachStepDef {

    private StreetSpecification streetSpecification;
    private DeliveryApproach deliveryApproach;

    @Given("^the following street specification \"([^\"]*)\"$")
    public void given_street_specification(String streetSpec) {
        this.streetSpecification = new StreetSpecification(streetSpec);
    }

    @Given("^using Delivery Approach One for delivering newspapers$")
    public void delivery_approach_one() {
        //this.deliveryApproach = new DeliveryApproachOne(this.streetSpecification.getStreet());
        this.deliveryApproach = DeliveryApproachFactory.createDeliveryApproach(APPROACH_ONE, this.streetSpecification.getStreet());
    }

    @Given("^using Delivery Approach Two for delivering newspapers$")
    public void delivery_approach_two() {
        this.deliveryApproach = DeliveryApproachFactory.createDeliveryApproach(APPROACH_TWO, this.streetSpecification.getStreet());
    }

    @Then("^the delivery order will be \"([^\"]*)\"$")
    public void delivery_order_will_be(String expectedDeliveryOrder) {
        List<Integer> order = this.deliveryApproach.getDeliveryOrder();
        String deliveryOrder = order.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        Assert.assertEquals(expectedDeliveryOrder, deliveryOrder);
    }

    @Then("^delivery person will cross the street (\\d+) time$")
    public void person_will_cross_street_n_times(int n) {
        Assert.assertEquals("Street crossing", n, this.deliveryApproach.getNumberOfStreetCrossings());
    }
}
