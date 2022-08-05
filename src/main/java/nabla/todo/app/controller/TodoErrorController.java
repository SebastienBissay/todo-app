package nabla.todo.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Sebastien Bissay
 */
@Controller("error")
public class TodoErrorController implements ErrorController {

    @ExceptionHandler(Exception.class)
    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return String.format("<html><head><title>Error Page</title></head><body><h2>Error Page</h2><div>Status code: <b>%s</b></div><div>Exception Message: <b>%s</b></div><body></html>",
                statusCode, exception == null ? "N/A" : exception.getMessage());
    }
}
