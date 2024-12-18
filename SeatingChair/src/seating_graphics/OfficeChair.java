package seating_graphics;

public class OfficeChair extends Chair 
{
    private String officeType;  // Specific property for OfficeChair

    // Constructor
    public OfficeChair(int pHeight, String pOfficeType) 
    {
        super(pHeight, 30, 150);  // Call the parent class constructor with min and max height
        this.officeType = pOfficeType;
    }

    // Getter for office type
    public String getOfficeType() 
    {
        return officeType;
    }

    // Setter for office type
    public void setOfficeType(String officeType) 
    {
        this.officeType = officeType;
    }
}
