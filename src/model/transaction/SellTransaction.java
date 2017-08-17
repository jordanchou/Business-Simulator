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
    /**
     * Constructs a SellTransaction using the year and an associated property
     * @param year the year for the transaction
     * @param property the property associated with the transaction
     */
    public SellTransaction(long year, Property property)
    {
        super(year, property);
    }

    /**
     * Updates the values of the properties
     */
    @Override
    public void update()
    {
        if (!(super.getPrimary().getProperties().contains(property)))
            throw new IllegalStateException("Primary company cannot sell: " + property.toString());

        Property property = super.getProperty();

        super.getPrimary().sell(property);
        //sell to unnamed buyer
    }
}