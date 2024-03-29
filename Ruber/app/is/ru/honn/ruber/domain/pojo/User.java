/*
 * @(#)User.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.pojo;

import java.util.Date;

/**
 * Pojo Class holding one User (Both drivers and riders)
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class User
{
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Date registered;
    private boolean driver;

    /**
     * Returns true if user is a driver
     * @return boolean
     */
    public boolean isDriver()
    {
        return driver;
    }

    public void setDriver(boolean driver)
    {
        this.driver = driver;
    }

    public User()
    {
    }

    public User(int id, String username, String firstName, String lastName, String password, String email, Date registered)
    {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.registered = registered;
        this.driver = false;
    }

    public User(String username, String firstName, String lastName, String password, String email, Date registered)
    {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.registered = registered;
        this.driver = false;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getRegistered()
    {
        return registered;
    }

    public void setRegistered(Date registered)
    {
        this.registered = registered;
    }
}




