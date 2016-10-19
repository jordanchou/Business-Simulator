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
package controller.factory;

import model.transaction.*;

public class TransactionFactory
{
    public TransactionFactory()
    {

    }

    public Transaction getTransaction(String line)
    {
        String[] lineArray;
        Transaction transaction = null;
        long year;

        lineArray = line.split(",");

        year = Long.parseLong(lineArray[0]);

        switch (lineArray[1])
        {
            case "S":
                transaction = new SellTransaction(year, lineArray[2]);
                break;

            case "B":
                transaction = new BuyTransaction(year, lineArray[2]);
                break;

            default:
                //throw exception!
        }

        return transaction;
    }
}