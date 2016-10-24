/*
FILE: TransactionReader.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE: Reads in Transaction objects from file
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package controller.reader;

import model.transaction.*;
import controller.*;

public class TransactionReader extends Reader
{
    TransactionManager tm;
    PropertyManager pm;

    /**
     * Constructs a TransactionReader with a TransactionManager and a PropertyManager
     * @param tm Used to store the Transactions
     * @param pm Used to store the necessary property reference associated with a Transaction
     */
    public TransactionReader(TransactionManager tm, PropertyManager pm)
    {
        this.tm = tm;
        this.pm = pm;
    }

    /**
     * Processes the line by parsing it to get the necessary values for a Transaction.
     * @param line The line to process
     */
    @Override
    public void processLine(String line)
    {
        String[] lineArray;
        Transaction transaction = null;
        long year;

        lineArray = line.split(",");
        System.out.println("HI");
        year = Long.parseLong(lineArray[0]);

        switch (lineArray[1])
        {
            case "S":
                transaction = new SellTransaction(year, pm.getProperty(lineArray[2]));

                break;

            case "B":
                transaction = new BuyTransaction(year, pm.getProperty(lineArray[2]));

                break;

            default:
                throw new IllegalArgumentException("Invalid transaction: " + line);
        }
        System.out.println("HI");
        System.out.println("HI4");
        transaction.setPrimary(pm.getPrimary());//Each transaction gets a reference to the primary company
        System.out.println("HI2");
        tm.addTransaction((Updateable<Transaction>)transaction);//Adds the transaction to the transaction manager
        System.out.println("HI5");
    }
}