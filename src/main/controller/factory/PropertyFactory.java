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

import model.property.*;

public class PropertyFactory
{
    public PropertyFactory()
    {

    }

    public Property getProperty(String line)
    {
        String[] lineArray;
        Property property = null;

        lineArray = line.split(",");

        switch (lineArray[1])
        {
            case "C":
                property = new Company(lineArray[0], lineArray[2], Double.parseDouble(lineArray[3]), new BankAccount());

                break;

            case "B":
                property = new BusinessUnit(lineArray[0], lineArray[2], Double.parseDouble(lineArray[3]),
                                            Double.parseDouble(lineArray[4]), Double.parseDouble(lineArray[5]));
                break;

            default:
                //throw exception!
        }

        return property;
    }
}