package org.resthub.todo;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    static final Logger logger = LoggerFactory.getLogger(TodoRepository.class);
    @Inject MongoTemplate mongoTemplate;
    
    public Todo create(Todo todo) {
         mongoTemplate.insert(todo);
         return todo;
    }
    
     public Todo update(Todo todo) {
         mongoTemplate.save(todo);
         return todo;
    }
    
    public Todo findById(String id) {
        return mongoTemplate.findById(id, Todo.class);
    }

    public List<Todo> findAll() {
        return mongoTemplate.findAll(Todo.class);
    }
    
    public void remove(String id) {
         mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Todo.class);
    }
    
    public void removeAll() {
        
        if (mongoTemplate.collectionExists(Todo.class)) {
            mongoTemplate.dropCollection(Todo.class);
        }
        
        if (!mongoTemplate.collectionExists(Todo.class)) {
            mongoTemplate.createCollection(Todo.class);
        }
         
    }
    
}
