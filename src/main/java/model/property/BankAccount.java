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
    public void update()
    {
        super.setValue(super.getValue() + super.getValue() * 0.05);
    }

    public String toString()
    {
        return super.getValue() + "";
    }

}