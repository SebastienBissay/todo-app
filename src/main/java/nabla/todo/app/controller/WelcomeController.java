package nabla.todo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Sebastien Bissay
 */
@Controller
public class WelcomeController {
    
    @GetMapping("/")
    public String root() {
        return "welcome";
    }
}
