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
