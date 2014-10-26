package is.ru.honn.ruber.domain.pojo;

/**
 * Created by sveinn on 25.10.2014.
 */
public class Review
{
    private int id;
    private int reviewerId;
    private int productId;
    private int tripId;
    private String comment;

    public Review(int id, int reviewerId, int productId, int tripId, String comment)
    {

        this.id = id;
        this.reviewerId = reviewerId;
        this.productId = productId;
        this.tripId = tripId;
        this.comment = comment;
    }

    public Review(int reviewerId, int productId, int tripId, String comment)
    {

        this.reviewerId = reviewerId;
        this.productId = productId;
        this.tripId = tripId;
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

    public int getTripId()
    {
        return tripId;
    }

    public void setTripId(int tripId)
    {
        this.tripId = tripId;
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
