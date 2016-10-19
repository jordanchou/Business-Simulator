/*
FILE: BankAccount.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.property;

public class BankAccount extends Property
{
    public BankAccount()
    {
        super();
    }


    @Override
    public double calcProfit()
    {
        double value;

        value = super.getValue();
        profit = 0.0;

        if (value >= 0.0)
        {
            profit = value * 1.05;
        }

        return profit;
    }

}