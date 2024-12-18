package seating_graphics;

public class WoodenChair extends Chair 
{
    private String woodType;  // Specific property for WoodenChair

    // Constructor
    public WoodenChair(int pHeight, String pWoodType) 
    {
        super(pHeight, 30, 100);  // Call the parent class constructor with min and max height
        this.woodType = pWoodType;
    }

    // Getter for wood type
    public String getWoodType() 
    {
        return woodType;
    }

    // Setter for wood type
    public void setWoodType(String woodType) 
    {
        this.woodType = woodType;
    }
}
