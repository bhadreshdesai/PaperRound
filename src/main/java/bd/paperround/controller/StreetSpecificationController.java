package bd.paperround.controller;

import bd.paperround.model.Street;
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
public class StreetSpecificationController {

    @RequestMapping(value = "/streetspecification", method = RequestMethod.POST)
    public Street streetSpecification(@RequestParam(value = "streetSpec") String streetSpec) {
        return new StreetSpecification(streetSpec).getStreet();
    }
}
