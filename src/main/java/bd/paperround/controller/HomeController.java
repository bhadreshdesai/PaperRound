package bd.paperround.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bhadresh Desai
 */
@Controller
public class HomeController {

    //@GetMapping(value = "/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage() {
        return "index";
    }
}
