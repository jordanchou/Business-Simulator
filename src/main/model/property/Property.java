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

    public Property()
    {
        value = 0.0;
        profit = 0.0;
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

    public abstract double calcProfit();
}