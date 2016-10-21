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
        pm.getPrimary().buy(pm.getProperty(super.getProperty()));
        ((Company)pm.getProperty((pm.getProperty(super.getProperty())).getOwner())).sell(pm.getProperty(super.getProperty()));
        //other company has to sell
    }
}
