/*
FILE: Reader.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE: provides a template for reading input files line by line
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/

package controller.reader;

import model.error.FileFormatException;
import model.property.BusinessUnit;
import model.property.Company;
import model.property.Property;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public abstract class Reader
{
    /**
     * Reads in a file using BufferedReader. Delegates the processing of each line of the file to subclasses.
     * @param file The name of the file to read from
     * @throws IOException
     */
    public void readFile(String file) throws IOException
    {
        FileInputStream stream = null;
        InputStreamReader streamReader;
        BufferedReader reader;

        try
        {
            stream = new FileInputStream(file);

            streamReader = new InputStreamReader(stream);
            reader = new BufferedReader(streamReader);
            String line;

            line = reader.readLine();
            line = reader.readLine();//Get rid of the first line


            while (line != null)
            {
                processLine(line);
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
                } catch (IOException e2)
                {
                    throw new IllegalArgumentException("File is incorrect.");
                }
            }
        }
        catch (IllegalArgumentException e)
        {
            try
            {
                stream.close();
            } catch (IOException e2)
            {
                throw new IllegalArgumentException("File is incorrect.");
            }


            throw new FileFormatException(e.getMessage(), e);
        }
        catch (ClassCastException e)
        {
            try
            {
                stream.close();
            } catch (IOException e2)
            {
                throw new IllegalArgumentException("File is incorrect.");
            }


            throw new FileFormatException(e.getMessage(), e);
        }
    }

    /**
     * Forces subclasses to decide how the line should be processed
     * @param line The line to process
     */
    protected abstract void processLine(String line);

}