package com.example.applicationeventtest.controller;

import com.example.applicationeventtest.dao.entity.UserEntity;
import com.example.applicationeventtest.events.ImportEvent;
import com.example.applicationeventtest.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/name")
    public Optional<UserEntity> findByName(@RequestParam(name = "value") String name) {
        doExpensiveWork(name);
        System.out.println("DONE");
        return userService.findByName(name);
    }

    private void doExpensiveWork(String message) {
        applicationEventPublisher.publishEvent(new ImportEvent(this, message));
    }
}
