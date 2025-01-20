package com.TekArchFlights.DataStoreService.Services.Interfaces;



import com.TekArchFlights.DataStoreService.Models.Users;

import java.util.List;
import java.util.Optional;


public interface UserService {
    /**
     * Retrieve all users.
     * @return List of all users.
     */
    List<Users> getAllUsers();

    /**
     * Retrieve a user by their ID.
     * @param id ID of the user to retrieve.
     * @return Optional containing the user if found, or empty if not found.
     */
    Optional<Users> getUserById(Long id);

    /**
     * Create a new user.
     * @param user User object to create.
     * @return The created user object.
     */
    Users createUser(Users user);

    /**
     * Update an existing user by ID.
     * @param id ID of the user to update.
     * @param user Updated user object.
     * @return The updated user object.
     */
    Users updateUser(Long id, Users user);

    /**
     * Delete a user by their ID.
     * @param id ID of the user to delete.
     */
    void deleteUser(Long id);
}