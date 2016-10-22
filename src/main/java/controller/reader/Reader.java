package controller.reader;

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
            line = reader.readLine();//Get rid of the first line lol.


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
    }


    protected abstract void processLine(String line);

}