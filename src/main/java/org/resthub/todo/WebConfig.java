package org.resthub.todo;

import com.mongodb.Mongo;
import java.net.UnknownHostException;
import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration @EnableWebMvc @ComponentScan(basePackages = "org.resthub.todo")
public class WebConfig extends WebMvcConfigurerAdapter {
    
    @Inject
    private Mongo mongo;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("**/*.html").addResourceLocations("/");
        registry.addResourceHandler("**/*.js").addResourceLocations("/");
        registry.addResourceHandler("**/*.css").addResourceLocations("/");
        registry.addResourceHandler("**/*.png").addResourceLocations("/");
    }

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }
    
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo, "todo");
    }
       
}
