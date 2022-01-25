package fr.lernejo.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class TodoListController {

    private final ArrayList<Todo> listTodos = new ArrayList<>();

    @GetMapping(value="/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Todo>> getTodo(){
        return new ResponseEntity<>(listTodos, HttpStatus.OK);
    }

    @PostMapping(value="/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> postTodo(@RequestBody Todo todo){
        listTodos.add(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

}
