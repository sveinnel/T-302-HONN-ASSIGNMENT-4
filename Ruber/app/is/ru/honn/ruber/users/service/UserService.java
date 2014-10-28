/*
 * @(#)UserService.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.users.service;

import is.ru.honn.ruber.domain.pojo.User;
import java.util.Date;
import java.util.List;

/**
 * Interface for UserService
 * Implementers should implement service that handles
 * manipulation for user related queries
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public interface UserService
{
    /**
     * Sign up user
     * @param username String User name
     * @param firstName String First name
     * @param lastName String Last name
     * @param password String Password
     * @param email String E-mail
     * @param registered Date registration date
     * @return User that has signed up
     * @throws UsernameExistsException
     */
    public User userSignup(String username, String firstName, String lastName,
                         String password, String email, Date registered)
      throws UsernameExistsException;

    /**
     * Returns user by username
     * @param username String User name
     * @return User
     * @throws UserNotFoundException
     */
    public User getUser(String username) throws UserNotFoundException;

    /**
     * Returns User by id
     * @param id int id of the user
     * @return User
     */
    public User getUserById(int id);

    /**
     * Returns all drivers
     * @return List of User (Drivers)
     * @throws UserNotFoundException
     */
    public List<User> getDrivers() throws UserNotFoundException;
}
