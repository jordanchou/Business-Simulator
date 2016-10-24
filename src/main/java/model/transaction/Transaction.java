/*
FILE: Transaction.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.transaction;

import java.util.*;
import controller.*;
import model.property.*;

public abstract class Transaction implements Comparable<Transaction>
{
    long year;
    Property property;
    Company primary;

    /**
     * Constructs a new Transaction object using the year and an associated property
     * @param year
     * @param property
     */
    public Transaction(long year, Property property)
    {
        this.year = year;
        this.property = property;
        this.primary = null;
    }

    /**
     * Compares two transaction objects
     * @param transaction
     * @return how similar the objects are
     */
    public int compareTo(Transaction transaction)
    {
        int value;

        if (transaction.getYear() > this.year)
        {
            value =  -1;
        }
        else if (transaction.getYear() < this.year)
        {
            value =  1;
        }
        else
        {
            value =  0;
        }

        return value;
    }

    /**
     * Retrieves the year
     * @return the year for the transaction
     */
    public long getYear()
    {
        return this.year;
    }

    /**
     * Retrieves the associated property for the transaction
     * @return the property for the transaction
     */
    public Property getProperty()
    {
        return property;
    }

    /**
     * Forces all subclasses of Transaction to implement an update method
     */
    public abstract void update();

    /**
     * Sets the primary company
     * @param primary The primary company for the simulation
     */
    public void setPrimary(Company primary)
    {
        this.primary = primary;
    }

    /**
     *  Retrieves the primary company set for the transaction
     * @return a reference to the primary Company
     */
    public Company getPrimary()
    {
        return primary;
    }

    @Override
    public String toString()
    {
        return "Transaction: " +
                "year=" + year +
                ", property=" + property +
                ", primary=" + primary;
    }
}