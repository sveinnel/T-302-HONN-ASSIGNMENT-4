package is.ru.honn.ruber.domain.dto;

import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.User;

/**
 * Created by sveinn on 26.10.2014.
 */
public class ReviewDTO
{
    private int id;
    private User reviewer;
    private Product product;
    private int rating;
    private String comment;

    public ReviewDTO(int id, User reviewer, Product product, int rating, String comment)
    {
        this.id = id;
        this.reviewer = reviewer;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public User getReviewer()
    {
        return reviewer;
    }

    public void setReviewer(User reviewer)
    {
        this.reviewer = reviewer;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
