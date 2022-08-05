package nabla.todo.app.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.websocket.server.PathParam;
import nabla.todo.app.model.Todo;
import nabla.todo.app.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Sebastien Bissay
 */
@Controller
public class TodoController {

    private final ITodoService todoService;
    
    @Autowired
    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @ModelAttribute("todoList")
    public List<Todo> addTodoListToModel() {
        return this.todoService.findAll();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - yyyy-MM-dd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/list-todos")
    public String todos(Model model) {
        model.addAttribute("todo", new Todo());
        return ("list-todos");
    }

    @GetMapping("/add-todo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return ("add-todo");
    }
    
    @GetMapping("/update-todo")
    public String addToto(@RequestParam("id") Long id, Model model) {
        model.addAttribute("todo", this.todoService.findById(id));
        return ("add-todo");
    }
}
