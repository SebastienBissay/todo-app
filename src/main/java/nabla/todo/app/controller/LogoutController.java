package nabla.todo.app.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sebastien Bissay
 */
public class LogoutController {

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo() {
        SecurityContextHolder.clearContext();
        return "/login";
    }
}
