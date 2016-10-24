/*
FILE: TransactionController.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package controller;

import java.util.*;
import java.io.*;
import controller.*;
import model.transaction.*;

public class TransactionManager
{
    Set<Updateable> transactions;//Set of transactions

    public TransactionManager()
    {
        transactions = new LinkedHashSet<Updateable>();//LinkedHashSet keeps insert order
    }

    /**
     * Goes through the transactions and 'updates' the ones for the current year
     * @param year The current year
     */
    public void update(long year)
    {

        for (Updateable transaction : transactions)
        {
            if (transaction.getYear() == year)
            {
                transaction.update();
            }
            else if (transaction.getYear() > year)
            {
                break;
            }

            //transactions.remove(transaction);
        }
    }

    /**
     * Adds a transaction to the TransactionManager
     * @param transaction The transaction to add
     */
    public void addTransaction(Updateable transaction)
    {
        for (Updateable t : transactions)
        {
            if (t.compareTo(transaction) == 1)//If the event being added is less than the others (in terms of years)
            {
                throw new IllegalArgumentException("Event date is invalid. Please check the years: " + transaction.toString());

            }
        }
        transactions.add(transaction);
    }

}