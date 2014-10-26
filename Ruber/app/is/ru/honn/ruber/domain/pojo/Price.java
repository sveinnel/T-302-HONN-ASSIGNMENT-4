package is.ru.honn.ruber.domain.pojo;

public class Price
{
    protected int id;
    protected String currencyCode;
    protected double lowEstimate;
    protected double highEstimate;
    protected double surgeMultiplier;
    protected double finalPrice;

  public Price()
  {
  }

    public Price(int id, String currencyCode, double lowEstimate, double highEstimate, double surgeMultiplier, double finalPrice)
    {
        this.id = id;
        this.currencyCode = currencyCode;
        this.lowEstimate = lowEstimate;
        this.highEstimate = highEstimate;
        this.surgeMultiplier = surgeMultiplier;
        this.finalPrice = finalPrice;
    }

    public Price(String currencyCode, double lowEstimate, double highEstimate, double surgeMultiplier, double finalPrice)
    {
        this.currencyCode = currencyCode;
        this.lowEstimate = lowEstimate;
        this.highEstimate = highEstimate;
        this.surgeMultiplier = surgeMultiplier;
        this.finalPrice = finalPrice;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public double getLowEstimate()
    {
        return lowEstimate;
    }

    public void setLowEstimate(double lowEstimate)
    {
        this.lowEstimate = lowEstimate;
    }

    public double getHighEstimate()
    {
        return highEstimate;
    }

    public void setHighEstimate(double highEstimate)
    {
        this.highEstimate = highEstimate;
    }

    public double getSurgeMultiplier()
    {
        return surgeMultiplier;
    }

    public void setSurgeMultiplier(double surgeMultiplier)
    {
        this.surgeMultiplier = surgeMultiplier;
    }

    public double getFinalPrice()
    {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice)
    {
        this.finalPrice = finalPrice;
    }
}
