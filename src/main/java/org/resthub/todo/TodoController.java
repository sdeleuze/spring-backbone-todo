package org.resthub.todo;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping("/api/todo")
public class TodoController {

    @Inject
    private TodoRepository todoRepository;
    
    static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json") @ResponseBody
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
    
    @RequestMapping(value = "{id}",method = RequestMethod.GET ) @ResponseBody
    
    public final Todo get( @PathVariable( "id" ) final String id ){
        return this.todoRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json") @ResponseStatus(HttpStatus.CREATED) @ResponseBody
    public Todo create(@RequestBody Todo todo) {
        Assert.notNull(todo);
        return todoRepository.create(todo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT) @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Todo todo, @PathVariable String id) {
        Assert.isTrue(todo.getId().equals(id));
        todoRepository.update(todo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable String id) {
        todoRepository.remove(id);
    }
}
