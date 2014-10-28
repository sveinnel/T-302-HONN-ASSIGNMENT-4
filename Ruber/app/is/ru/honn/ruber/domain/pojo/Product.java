/*
 * @(#)Product.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.pojo;

/**
 * Pojo Class for product object
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class Product
{
  protected int id;
  protected String description;
  protected String displayName;
  protected int capacity;
  protected String image;
  protected int driverId;
  protected int priceId;

    public Product(int id, String description, String displayName, int capacity, String image, int driverId, int priceId)
    {
        this.id = id;
        this.description = description;
        this.displayName = displayName;
        this.capacity = capacity;
        this.image = image;
        this.driverId = driverId;
        this.priceId = priceId;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public int getDriverId()
    {
        return driverId;
    }

    public void setDriverId(int driverId)
    {
        this.driverId = driverId;
    }

    public int getPriceId()
    {
        return priceId;
    }

    public void setPriceId(int priceId)
    {
        this.priceId = priceId;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", capacity=" + capacity +
                ", image='" + image + '\'' +
                ", driverId=" + driverId +
                ", priceId=" + priceId +
                '}';
    }
}
