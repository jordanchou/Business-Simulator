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
import view.*;

public class PropertyManager
{
    PropertyFactory pf;
    Map<String, Property> properties;
    List<WageObserver> observers;
    Company primary;

    public PropertyManager(PropertyFactory pf, String file)
    {
        this.pf = pf;
        properties = new LinkedHashMap<String, Property>();
        observers = new ArrayList<WageObserver>();
        primary = null;
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
        for (Property property : properties.values())
            property.calcProfit();
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

    public void notifyObservers(double multiplier)
    {
        for (WageObserver observer : observers)
            observer.update(multiplier);
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
                    ((Company) properties.get(property.getOwner())).addProperty(property);
                }//Error check for if owner is not in map


                if ((primary == null) && (property instanceof Company))
                {
                    primary = (Company) property;
                }

                properties.put(property.getName(), property);

                if (property instanceof BusinessUnit)
                    observers.add((BusinessUnit)property);//don't hate me dave

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
                    throw new IOException("wtf");
                }
            }
        }
    }

    public Company getPrimary()
    {
        return primary;
    }

    public Property getProperty(String name)
    {
        return properties.get(name);
    }




}
