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

    public BusinessUnit()
    {
        super();
        revenue = 0.0;
        wages = 0.0;
    }

    public BusinessUnit(String name, String owner, double value, double revenue, double wages)
    {
        super(name, owner, value);
        this.revenue = revenue;
        this.wages = wages;
    }

    public double getRevenue()
    {
        return revenue;
    }

    public double getWages()
    {
        return wages;
    }

    public void update(double change)
    {
        wages = wages * change;
    }

    public void setRevenue(double revenue)
    {
        this.revenue = revenue;
    }

    @Override
    public void calcProfit()
    {
        super.setProfit(revenue - wages);
    }


}