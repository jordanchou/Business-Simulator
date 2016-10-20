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
package controller;

import java.io.*;
import java.util.*;
import model.property.*;
import controller.factory.*;

public class PropertyManager
{
    PropertyFactory pf;
    Map<String,Property> properties;
    Company primary;

    public PropertyManager(PropertyFactory pf, String file)
    {
        this.pf = pf;
        properties = new HashMap<String,Property>();

        try
        {
            readFile(file);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Invalid property file");
        }
    }


    public void updateAccounts()
    {

    }

    public List<Property> getCompanies()
    {
        List<Property> companies;

        companies = new ArrayList<Property>();

        for (Property property : properties.values())
        {
            if (property instanceof Company)
                companies.add(property);
        }

        return companies;
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
            Property property;
            String line;

            line = reader.readLine();
            line = reader.readLine();//Get rid of the first line lol.


            while (line != null)
            {
                property = pf.getProperty(line);
                //GET OWNER AND STUFF!
                if (!("".equals(property.getOwner())))
                {
                    ((Company)properties.get(property.getOwner())).addProperty(property.getName());
                }//Error check for if owner is not in map

                properties.put(property.getName(), property);
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
