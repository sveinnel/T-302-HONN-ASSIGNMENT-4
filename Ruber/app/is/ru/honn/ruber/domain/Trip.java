package is.ru.honn.ruber.domain;

import java.sql.Date;

public class Trip
{
    protected int id;
    protected Date requestTime;
    protected int productId;
    protected TripStatus status;
    protected double distance;
    protected Date startTime;
    protected Date endTime;
    protected double startLongitude;
    protected double endLongitude;
    protected double startLatitude;
    protected double endLatitude;
    protected int riderId;


    public Trip() {

    }

    public Trip(int id, Date requestTime, int productId, TripStatus status, double distance, Date startTime, Date endTime)
    {
        this.id = id;
        this.requestTime = requestTime;
        this.productId = productId;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Trip(Date requestTime, int productId, TripStatus status, double distance, Date startTime, Date endTime)
    {
        this.requestTime = requestTime;
        this.productId = productId;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //TODO: implement Product getter from DB based on product id
    public Trip(int id, int productId, Date requestTime, Date startTime, Date endTime, float startlongitude, float endLongiTude, float startLatitude, float endLatitude, float distance, boolean completed, int riderId) {
        this.id = id;
        this.requestTime = requestTime;
        this.productId = productId;
        if(completed)
        {
            this.status = TripStatus.COMPLETED;
        }
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }


    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", productId=" + productId +
                ", status=" + status +
                ", distance=" + distance +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startLongitude=" + startLongitude +
                ", endLongitude=" + endLongitude +
                ", startLatitude=" + startLatitude +
                ", endLatitude=" + endLatitude +
                ", riderId=" + riderId +
                '}';
    }
}
