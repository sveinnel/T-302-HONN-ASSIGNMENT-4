/*
 * @(#)UserDataGateway.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.pojo.User;
import is.ruframework.data.RuDataAccess;
import java.util.List;

/**
 * Interface for data gateway
 * Implementers implement connection to
 * data storages
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public interface UserDataGateway extends RuDataAccess
{
    /**
     * Adds user to datastorage
     * @param user User user to be added
     * @return int id of the users
     */
    public int addUser(User user);

    /**
     * Returns user by username
     * @param username String username
     * @return User with that username
     */
    public User getUserByUsername(String username);

    /**
     * Returns user by username
     * @param id int id of the user
     * @return User with that id
     */
    public User getUserById(int id);

    /**
     * Returns All drivers
     * @return List of all drivers
     */
    public List<User> getDrivers();
}