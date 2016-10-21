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
    public SellTransaction(long year, String property)
    {
        super(year, property);
    }

    public void update(PropertyManager pm)
    {
        Property property = pm.getProperty(super.getProperty());

        pm.getPrimary().sell(property);
        //sell to unnamed buyer
    }
}