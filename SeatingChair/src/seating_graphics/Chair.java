package seating_graphics;



public class Chair
{
    private int height;        // Current height of the chair
    private int maxHeight;     // Maximum height of the chair
    private int minHeight;     // Minimum height of the chair

    // Constructor
    public Chair(int pHeight, int pMinHeight, int pMaxHeight)
    {
        this.height = pHeight;
        this.minHeight = pMinHeight;
        this.maxHeight = pMaxHeight;
    }

    
    // Method to raise the chair height
    public void raise(int pIncrease) 
    {
        if (height + pIncrease <= maxHeight) 
        {
            height += pIncrease;
        } else
        {
            height = maxHeight; // Cap height to max
        }
    }

    // Method to lower the chair height
    public void lower(int pDecrement) 
    {
        if (height - pDecrement >= minHeight) 
        {
            height -= pDecrement;
        } else 
        {
            height = minHeight; // Cap height to min
        }
    }
    
    // Getter for height
    public int getHeight()
    {
        return height;
    }

    // Getter for min height
    public int getMinHeight() 
    {
        return minHeight;
    }

    // Getter for max height
    public int getMaxHeight() 
    {
        return maxHeight;
    }

    // Setter for height (with bounds check)
    public void setHeight(int pHeight) 
    {
        if (pHeight >= minHeight && pHeight <= maxHeight) 
        {
            this.height = pHeight;
        } else 
        {
            System.out.println("Invalid height. Must be between " + minHeight + " and " + maxHeight);
            
        }
    }


}
