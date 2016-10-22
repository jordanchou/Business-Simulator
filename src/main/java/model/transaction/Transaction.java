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
package model.transaction;

import java.util.*;
import controller.*;
import model.property.*;

public abstract class Transaction implements Comparable<Transaction>
{
    long year;
    Property property;
    Company primary;


    public Transaction(long year, Property property)
    {
        this.year = year;
        this.property = property;
    }

    public int compareTo(Transaction transaction)
    {
        if (transaction.getYear() > this.year)
        {
            return -1;
        }
        else if (transaction.getYear() < this.year)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public long getYear()
    {
        return this.year;
    }

    public Property getProperty()
    {
        return property;
    }

    public abstract void update();

    public void setPrimary(Company primary)
    {
        this.primary = primary;
    }

    public Company getPrimary()
    {
        return primary;
    }
}