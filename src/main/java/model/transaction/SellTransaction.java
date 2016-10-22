/*
FILE: SellTransaction.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.transaction;

import controller.*;
import model.property.*;

public class SellTransaction extends Transaction
{
    public SellTransaction(long year, Property property)
    {
        super(year, property);
    }

    @Override
    public void update()
    {
        Property property = super.getProperty();

        super.getPrimary().sell(property);
        //sell to unnamed buyer
    }
}