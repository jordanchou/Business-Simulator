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
package controller.reader;

import model.transaction.*;
import controller.*;

public class TransactionReader extends Reader
{
    TransactionManager tm;
    PropertyManager pm;

    public TransactionReader(TransactionManager tm, PropertyManager pm)
    {
        this.tm = tm;
        this.pm = pm;
    }

    @Override
    public void processLine(String line)
    {
        String[] lineArray;
        Transaction transaction = null;
        long year;

        lineArray = line.split(",");

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
                //throw exception!
        }

        transaction.setPrimary(pm.getPrimary());

        tm.addTransaction(transaction);
    }
}