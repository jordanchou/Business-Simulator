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
                property = new Company(lineArray[0], (Company)properties.getProperty(lineArray[2]),
                                        Double.parseDouble(lineArray[3]), new BankAccount());

                break;

            case "B":
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
}