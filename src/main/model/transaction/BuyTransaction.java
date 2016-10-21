/*
FILE: Event.java
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

public class BuyTransaction extends Transaction
{
    public BuyTransaction(long year, String property)
    {
        super(year, property);
    }

    public void update(PropertyManager pm)
    {
        Property property = pm.getProperty(super.getProperty());



        Company owner = (Company)pm.getProperty(property.getOwner());

        if (owner != null)
        {
            owner.sell(property);
        }

        pm.getPrimary().buy(property);
        //other company has to sell
    }
}
