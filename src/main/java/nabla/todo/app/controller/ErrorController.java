package nabla.todo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sebastien Bissay
 */
@Controller("error")
public class ErrorController {
    
    @ExceptionHandler(Exception.class)
    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView handleException(Exception e) {
        return new ModelAndView("error", "errorMessage", e.getLocalizedMessage());
    }
    
}
