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
import controller.factory.*;
import model.transaction.*;
import model.property.*;

public class TransactionManager
{
    TransactionFactory tf;
    List<Transaction> transactions;


    public TransactionManager(TransactionFactory tf, String file)
    {
        this.tf = tf;
        transactions = new ArrayList<Transaction>();

        try
        {
            readFile(file);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Invalid events file");
        }
    }

    public void update(PropertyManager properties, long year)
    {
        for (Transaction transaction : transactions)
        {
            if (transaction.getYear() == year)
            {
                transaction.update(properties);
            }
            else if (transaction.getYear() > year)
            {
                break;//change to while-iterator
            }

            //transactions.remove(transaction);
        }
    }

    private void readFile(String file) throws IOException
    {
        FileInputStream stream = null;
        InputStreamReader streamReader;
        BufferedReader reader;

        try
        {
            stream = new FileInputStream(file);

            streamReader = new InputStreamReader(stream);
            reader = new BufferedReader(streamReader);
            Transaction transaction;
            String line;

            line = reader.readLine();
            line = reader.readLine();//Get rid of the first line lol.


            while (line != null)
            {
                transaction = tf.getTransaction(line);
                transactions.add(transaction);
                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            if (stream != null)
            {
                try
                {
                    stream.close();
                }
                catch (IOException e2)
                {
                    throw new IOException("wtf");
                }
            }
        }
    }
}