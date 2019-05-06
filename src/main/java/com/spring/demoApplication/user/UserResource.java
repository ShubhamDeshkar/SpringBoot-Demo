package com.spring.demoApplication.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        // HATEOAS
        // creating a resource and adding user object to it quickly
        Resource<User> resource = new Resource<User>(user);
        // getting the link to the method and building using linkBuilder
        ControllerLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        // adding the built link to the resource that needs to be returned
        resource.add(linkBuilder.withRel("all-users"));

        return resource;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(savedUser.getId())
                       .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        User user = service.deleteUserById(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
