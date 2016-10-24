/*
FILE: BusinessUnit.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.property;

import view.*;

public class BusinessUnit extends Property implements WageObserver
{
    private double revenue;
    private double wages;

    /**
     * Constructs a default BusinessUnit
     */
    public BusinessUnit()
    {
        super();
        revenue = 0.0;
        wages = 0.0;
    }

    /**
     * Alternate constructor: Constructs a BusinessUnit with all of the required fields
     * @param name The name of the BusinessUnit
     * @param owner Reference to the owner of the BusinessUnit
     * @param value The value of the BusinessUnit
     * @param revenue The revenue of the BusinessUnit
     * @param wages The wages of the BusinessUnit
     */
    public BusinessUnit(String name, Company owner, double value, double revenue, double wages)
    {
        super(name, owner, value);
        this.revenue = revenue;
        this.wages = wages;
    }

    /**
     * Retrieves the revenue for the BusinessUnit
     * @return revenue
     */
    public double getRevenue()
    {
        return revenue;
    }

    /**
     * Retrieves the wages for the BusinessUnit
     * @return wages
     */
    public double getWages()
    {
        return wages;
    }

    /**
     * Updates the wages for the company based off of a multiplier
     * @param change A multiplier for how much to change the wages by
     */
    public void update(double change)
    {
        wages = wages * change;
    }

    /**
     * Sets the revenue of the BusinessUnit to the import
     * @param revenue The revenue to set to
     */
    public void setRevenue(double revenue)
    {
        this.revenue = revenue;
    }

    /**
     * Updates the profit of the BusinessUnit to be the revenue take the wages
     */
    @Override
    public void update()
    {
        super.setProfit(revenue - wages);
    }
}