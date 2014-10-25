package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.data.AddReviewException;

import java.util.List;

/**
 * Created by sveinn on 25.10.2014.
 */
public interface DriverService
{
    public List<Product> getAllProducts();
    public List<Review> getReviewsByProductId(int productId);
    public void addReview(int productId, int riderId, int rate, int tripId, String comment) throws AddReviewException;
}
