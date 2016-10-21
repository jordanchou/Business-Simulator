/*
FILE: CompanyController.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.property;

public abstract class Property
{
    double value;
    double profit;
    String name;
    String owner;

    public Property()
    {
        value = 0.0;
        profit = 0.0;
        name = null;
        owner = null;
    }

    public Property(String name, String owner, double value)
    {
        this.name = name;
        this.owner = owner;
        this.value = value;
        this.profit = 0.0;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public void setProfit(double profit)
    {
        this.profit = profit;
    }

    public double getValue()
    {
        return this.value;
    }

    public String getName()
    {
        return name;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String toString()
    {
        return "Name: " + name;
    }

    public abstract double calcProfit();


}