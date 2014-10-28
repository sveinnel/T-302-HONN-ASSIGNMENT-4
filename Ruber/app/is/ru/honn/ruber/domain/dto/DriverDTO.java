/*
 * @(#)DriverDTO.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.dto;

import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.User;

import java.util.List;

/**
 * DTO class used for sending Driver to client
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class DriverDTO {
    private User user;
    private List<Product> product;
    public DriverDTO (User u, List<Product> p){
        /*this.user.setId(u.getId());
        this.user.setUsername(u.getUsername());
        this.user.setFirstName(u.getFirstName());
        this.user.setLastName(u.getLastName());
        this.user.setEmail(u.getEmail());
        this.user.setRegistered(u.getRegistered());
        this.user.setDriver(true);*/
        this.user = u;
        this.product = p;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
