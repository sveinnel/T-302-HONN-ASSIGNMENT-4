package is.ru.honn.ruber.domain.dto;

import is.ru.honn.ruber.domain.pojo.Price;
import is.ru.honn.ruber.domain.pojo.User;

/**
 * Created by sveinn on 26.10.2014.
 */
public class ProductDTO
{
    private int id;
    private String description;
    private String displayName;
    private int capacity;
    private String image;
    private User driver;
    private Price price;

    public ProductDTO(int id, String description, String displayName, int capacity, String image, User driver, Price price)
    {
        this.id = id;
        this.description = description;
        this.displayName = displayName;
        this.capacity = capacity;
        this.image = image;
        this.driver = driver;
        this.price = price;
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

    public User getDriver()
    {
        return driver;
    }

    public void setDriver(User driver)
    {
        this.driver = driver;
    }

    public Price getPrice()
    {
        return price;
    }

    public void setPrice(Price price)
    {
        this.price = price;
    }
}
