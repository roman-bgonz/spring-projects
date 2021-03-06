package com.todo.rest.webservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.todo.rest.webservices.models.Todo;

@Component
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<>();
	private static Long idCounter = 0L;

	static {
		todos.add(new Todo(++idCounter, "Roman", "Learn to dance", new Date(), false));
		todos.add(new Todo(++idCounter, "Roman", "Learn React JS", new Date(), false));
		todos.add(new Todo(++idCounter, "Roman", "Learn Spring boot", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);

		if (todo == null)
			return null;
		if (todos.remove(todo))
			return todo;

		return null;
	}

	public Todo saveTodo(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}

		return todo;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
