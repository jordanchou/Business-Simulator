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
import controller.reader.*;
import model.transaction.*;

public class TransactionManager
{
    List<Transaction> transactions;

    public TransactionManager()
    {
        transactions = new ArrayList<Transaction>();
    }

    public void update(long year)
    {
        for (Transaction transaction : transactions)
        {
            if (transaction.getYear() == year)
            {
                transaction.update();
            }
            else if (transaction.getYear() > year)
            {
                break;//change to while-iterator
            }

            //transactions.remove(transaction);
        }
    }

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }

}