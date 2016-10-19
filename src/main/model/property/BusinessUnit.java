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

public class BusinessUnit extends Property
{
    private double revenue;
    private double wages;

    public BusinessUnit()
    {
        super();
        revenue = 0.0;
        wages = 0.0;
    }

    public BusinessUnit(String name, double value, double revenue, double wages)
    {
        super(name, value);
        this.revenue = revenue;
        this.wages = wages;
    }

    @Override
    public double calcProfit()
    {
        return revenue-wages;
    }

    public double getRevenue()
    {
        return revenue;
    }

    public double getWages()
    {
        return wages;
    }

}