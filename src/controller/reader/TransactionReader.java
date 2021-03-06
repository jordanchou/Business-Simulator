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

import java.util.Arrays;

public class TransactionReader extends Reader
{
    EventManager tm;
    PropertyManager pm;

    /**
     * Constructs a TransactionReader with a TransactionManager and a PropertyManager
     * @param tm Used to store the Transactions
     * @param pm Used to store the necessary property reference associated with a Transaction
     */
    public TransactionReader(EventManager tm, PropertyManager pm)
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
;
        year = Long.parseLong(lineArray[0]);

        switch (lineArray[1])
        {
            case "S":
                checkTransaction(lineArray);
                transaction = new SellTransaction(year, pm.getProperty(lineArray[2]));

                break;

            case "B":
                checkTransaction(lineArray);
                transaction = new BuyTransaction(year, pm.getProperty(lineArray[2]));
                break;

            default:
                throw new IllegalArgumentException("Invalid transaction: " + line);
        }

        if (transaction.getProperty().equals(pm.getPrimary()))
            throw new IllegalArgumentException("Cannot buy/sell primary company: " + line);

        transaction.setPrimary(pm.getPrimary());//Each transaction gets a reference to the primary company
        tm.add(transaction);//Adds the transaction to the transaction manager

    }

    /**
     * Checks if a transaction is valid
     * @param lineArray Line for transaction which has been split
     */
    public void checkTransaction(String[] lineArray)
    {
        if ("".equals(lineArray[0]))
            throw new IllegalArgumentException("Year is empty for transaction: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[1]))
            throw new IllegalArgumentException("Type is empty for transaction: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[2]))
            throw new IllegalArgumentException("Property is empty for transaction " + Arrays.toString(lineArray));

        if (lineArray.length != 3)
            throw new IllegalArgumentException("Transaction line is invalid: " + Arrays.toString(lineArray));
    }
}