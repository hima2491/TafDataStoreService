package com.TekArchFlights.DataStoreService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    import com.TekArchFlights.DataStoreService.Models.Users;
import com.TekArchFlights.DataStoreService.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/users")
    public class UserController {

        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public List<Users> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Users> getUser(@PathVariable Long id) {
            return userService.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Users> createUser(@RequestBody Users user) {
            return ResponseEntity.ok(userService.createUser(user));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
            try {
                return ResponseEntity.ok(userService.updateUser(id, user));
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            try {
                userService.deleteUser(id);
                return ResponseEntity.noContent().build();
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }
    }

