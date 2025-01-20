package com.TekArchFlights.DataStoreService.Services;

import com.TekArchFlights.DataStoreService.Models.Users;
import com.TekArchFlights.DataStoreService.Repositories.UserRepository;
import com.TekArchFlights.DataStoreService.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Users createUser(Users user) {
        // Validate data, if needed (e.g., check for duplicate username/email)
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Long id, Users user) {
        return userRepository.findById(id).map(existingUser -> {
            user.setUserId(id); // Ensure the user ID matches the existing record
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}