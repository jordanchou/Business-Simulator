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

import model.property.*;
import controller.*;

public class PropertyReader extends Reader
{
    PropertyManager properties;

    public PropertyReader(PropertyManager pm)
    {
        this.properties = pm;
    }

    @Override
    public void processLine(String line)
    {
        String[] lineArray;
        Property property = null;
        Company primary;

        lineArray = line.split(",");

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
                //throw exception!
        }

        if (!(null == property.getOwner()))
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