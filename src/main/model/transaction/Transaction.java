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

public abstract class Transaction implements Comparable<Transaction>
{
    long year;



    public Transaction()
    {

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
}