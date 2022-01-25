package fr.lernejo.todo;

import org.springframework.boot;

@RestController
public class TodoListController {

    @GetMapping(value="/api/todo", produces = MediaType.TEXT_PLAIN_VALUE)
    public static void getTodo(){

        return "toto";
    }

    @PostMapping(value="/api/todo", produces = MediaType.TEXT_PLAIN_VALUE)
    public static void postTodo(){
        Todo todo = new Todo("message","toto");
        return "test";
    }

}
