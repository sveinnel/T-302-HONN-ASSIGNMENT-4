/*
 * @(#)UserData.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.pojo.User;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ru.honn.ruber.users.service.UsernameExistsException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

/**
 * Data Gateway for users to database
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class UserData extends RuData implements UserDataGateway
{
  public int addUser(User user)
  {
    SimpleJdbcInsert insert =
        new SimpleJdbcInsert(getDataSource())
            .withTableName("ru_users")
            .usingGeneratedKeyColumns("id");

    Map<String, Object> parameters = new HashMap<String, Object>(7);
    parameters.put("username", user.getUsername());
    parameters.put("firstname", user.getFirstName());
    parameters.put("lastname", user.getLastName());
    parameters.put("password", user.getPassword());
    parameters.put("email", user.getEmail());
    parameters.put("registered", new Date());
    parameters.put("driver", false);

    int returnKey;

    try
    {
      returnKey = insert.executeAndReturnKey(parameters).intValue();
    }
    catch(DataIntegrityViolationException divex)
    {
      throw new UsernameExistsException("User " + user.getUsername() + " already exits", divex);
    }

    user.setId(returnKey);
    return returnKey;
  }

  public User getUserByUsername(String username)
  {
    Collection<String> users;
    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    User user;
    try
    {
      user = (User)jdbcTemplate.queryForObject(
          "select * from ru_users where username = '" + username + "'", new UserRowMapper());
    }
    catch (EmptyResultDataAccessException erdaex)
    {
      throw new UserNotFoundException("No user found with username: " + username);
    }
    return user;
  }

    @Override
    public User getUserById(int id)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        User user;
        try
        {
            user = (User)jdbcTemplate.queryForObject(
                    "select * from ru_users where id = " + Integer.toString(id), new UserRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new UserNotFoundException("No user found with id: " + id);
        }
        return user;
    }

    @Override
    public List<User> getDrivers() {
        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<User> drivers;
        drivers = template.query("select * from ru_users where driver = 1", new UserRowMapper());
        return drivers;
    }


}
