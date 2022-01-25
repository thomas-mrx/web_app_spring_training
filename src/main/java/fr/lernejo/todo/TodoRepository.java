package fr.lernejo.todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
