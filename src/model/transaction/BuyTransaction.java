/*
FILE: BuyTransaction.java
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
    /**
     *  Constructs a BuyTransaction using the year and property
     * @param year year of the transaction
     * @param property the property associated with the Transaction
     */
    public BuyTransaction(long year, Property property)
    {
        super(year, property);
    }


    /**
     * Does the transaction on the associated property
     */
    public void update()
    {
        if (super.getPrimary().getProperties().contains(property))
            throw new IllegalStateException("Primary company cannot buy: " + property.toString());

        Property property = super.getProperty();
        Company owner = property.getOwner();

        if (owner != null)
        {
            owner.sell(property);
        }

        super.getPrimary().buy(property);//Sells to unnamed buyer
    }
}
