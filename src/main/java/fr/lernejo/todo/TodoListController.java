package fr.lernejo.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListController {

    private final TodoRepository repository;

    public TodoListController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value="/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<TodoEntity>> getTodo(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value="/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoEntity> postTodo(@RequestBody TodoEntity todo){
        if(todo.author.isEmpty() || todo.message.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        try {
            repository.save(todo);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

}
