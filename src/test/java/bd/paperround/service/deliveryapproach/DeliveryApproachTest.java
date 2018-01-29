package bd.paperround.service.deliveryapproach;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author Bhadresh Desai
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber-report.json"})
public class DeliveryApproachTest {

}
