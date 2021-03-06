/*
FILE: PropertyReader.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE: Reads in Property objects from file
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package controller.reader;

import model.property.*;
import controller.*;
import java.util.*;

public class PropertyReader extends Reader
{
    PropertyManager properties;

    /**
     * Constructs a PropertyReader given a PropertyManager
     * @param pm
     */
    public PropertyReader(PropertyManager pm)
    {
        this.properties = pm;
    }

    /**
     * Overrides the abstract processLine method from Reader. This method processes a line and adds it to the
     * PropertyManager
     * @param line
     */
    @Override
    public void processLine(String line)
    {
        String[] lineArray;
        Property property = null;
        Company primary;

        lineArray = line.split(",");

        /**
         * Check that owner has been added to the map
         */
        if (!("".equals(lineArray[2])))
        {
            if (properties.getProperty(lineArray[2]) == null)
                throw new IllegalArgumentException("Invalid owner for property: " + line);
        }


        switch (lineArray[1])
        {
            case "C":
                checkCompany(lineArray);
                property = new Company(lineArray[0], (Company)properties.getProperty(lineArray[2]),
                                        Double.parseDouble(lineArray[3]), new BankAccount());

                break;

            case "B":
                checkBusinessUnit(lineArray);
                property = new BusinessUnit(lineArray[0], (Company)properties.getProperty(lineArray[2]),
                                            Double.parseDouble(lineArray[3]), Double.parseDouble(lineArray[4]),
                                            Double.parseDouble(lineArray[5]));
                break;

            default:
                throw new IllegalArgumentException("Invalid property type: " + lineArray[1]);
        }


        if (!(null == (property.getOwner())))
        {
            property.getOwner().addProperty(property);
        }//Error check for if owner is not in map

        primary = properties.getPrimary();

        if ((primary == null) && (property instanceof Company))
        {
            properties.setPrimary((Company) property);
        }

        properties.addProperty(property);
    }

    /**
     * Checks a company for validity
     * @param lineArray the line to check as an array
     */
    public void checkCompany(String[] lineArray)
    {
        if ("".equals(lineArray[0]))
            throw new IllegalArgumentException("Name is empty for company: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[1]))
            throw new IllegalArgumentException("Type is empty for company: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[3]))
            throw new IllegalArgumentException("Worth is empty for company: " + Arrays.toString(lineArray));
    }

    /**
     * Checks a line to see if it is a valid business unit
     * @param lineArray the line to check as an array
     */
    public void checkBusinessUnit(String[] lineArray)
    {
        if ("".equals(lineArray[0]))
            throw new IllegalArgumentException("Name is empty for company: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[1]))
            throw new IllegalArgumentException("Type is empty for company: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[3]))
            throw new IllegalArgumentException("Worth is empty for company: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[4]))
            throw new IllegalArgumentException("Name is empty for company: " + Arrays.toString(lineArray));

        if ("".equals(lineArray[5]))
            throw new IllegalArgumentException("Name is empty for company: " + Arrays.toString(lineArray));

    }
}