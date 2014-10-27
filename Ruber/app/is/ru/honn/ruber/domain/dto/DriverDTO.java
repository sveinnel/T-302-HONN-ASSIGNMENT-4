package is.ru.honn.ruber.domain.dto;

import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.User;

import java.util.List;

/**
 * Created by emil on 26.10.2014.
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
