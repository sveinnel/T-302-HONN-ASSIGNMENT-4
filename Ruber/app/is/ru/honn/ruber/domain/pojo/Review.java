/*
 * @(#)Review.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.pojo;

/**
 * Pojo Class holding Rider reviews
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class Review
{
    private int id;
    private int reviewerId;
    private int productId;
    private int rating;
    private String comment;

    public Review(int id, int reviewerId, int productId, int rating, String comment)
    {
        this.id = id;
        this.reviewerId = reviewerId;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(int reviewerId, int productId, int rating, String comment)
    {
        this.reviewerId = reviewerId;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
    }

    public Review()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getReviewerId()
    {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId)
    {
        this.reviewerId = reviewerId;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
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
