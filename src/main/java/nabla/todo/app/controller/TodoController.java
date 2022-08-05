package nabla.todo.app.controller;

import java.util.List;
import nabla.todo.app.model.Todo;
import nabla.todo.app.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        // Date - yyyy-MM-dd
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, false));
//    }
    @GetMapping("/list-todos")
    public String todos(Model model) {
        model.addAttribute("todo", new Todo());
        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "add-todo";
    }

    @GetMapping("/update-todo")
    public String addTodo(@RequestParam("id") Long id, Model model) {
        if (this.todoService.findById(id) == null) {
            return ("redirect:list-todos");
        }
        model.addAttribute("todo", this.todoService.findById(id));
        return "add-todo";
    }

    @PostMapping("/add-todo")
    public String createTodo(@ModelAttribute Todo todo, BindingResult bindingResult) {
        Todo newTodo = new Todo();
        if (todo.getId() != null) {
            newTodo = this.todoService.findById(todo.getId());
            newTodo.copy(todo);
            this.todoService.save(newTodo);
        } else {
            this.todoService.save(todo);
        }
        return "redirect:list-todos";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam("id") Long id) {
        this.todoService.delete(id);
        return "redirect:list-todos";
    }
}
