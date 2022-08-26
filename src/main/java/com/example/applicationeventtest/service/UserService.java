package com.example.applicationeventtest.service;

import com.example.applicationeventtest.dao.entity.UserEntity;
import com.example.applicationeventtest.dao.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findByName(String name) {
        return userRepository.findByName(name);
    }


}
