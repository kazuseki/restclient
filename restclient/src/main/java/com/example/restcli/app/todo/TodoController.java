package com.example.restcli.app.todo;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restcli.domain.service.TodoAccountService;

@Controller
@RequestMapping("rest")
public class TodoController {

	@Inject
	TodoAccountService todoAccountService;

    @ModelAttribute
    public TodoTitleForm setUpTodoTitleForm() {
    	TodoTitleForm todoTitleForm = new TodoTitleForm();
        return todoTitleForm;
    }

    @GetMapping
    public String input(Model model) {
    	return "todo/input";
    }

	@GetMapping("todolist")
	public String listTodo(Model model) {

		String todooneline = todoAccountService.findAll();

		System.out.println(todooneline);

		model.addAttribute("todooneline", todooneline);

		return "todo/list";

	}

	@PostMapping("todoOne")
	public String listOne(TodoTitleForm todoTitleForm,Model model) {

		String todoTitle = todoTitleForm.getTodoTitle();

		String todoOnelineByTitle = todoAccountService.findByTodoTitle(todoTitle);

		System.out.println(todoOnelineByTitle + "restcliのTodoController listOneメソッド");

		model.addAttribute("todoOnelineByTitle", todoOnelineByTitle);

		return "todo/listone";
	}

}
