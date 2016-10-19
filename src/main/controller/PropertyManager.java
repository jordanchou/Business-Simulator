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

import java.util.*;
import model.property.*;
import controller.factory.*;

public class PropertyManager
{
    Map<String,Property> properties;
    Company primary;

    public PropertyManager(PropertyFactory pf, String file)
    {
        readFile();
    }


    public void updateAccounts()
    {

    }

    public List<Property> getCompanies()
    {
        return null;
    }

    private void readFile(PropertyFactory pf, String file)
    {
        BufferedReader reader = new BufferedReader(file);
        String line;

        properties = new HashMap<String,Property>();

        line = reader.readLine();
        line = reader.readLine();//Get rid of the first line lol.

        while (line != null)
        {

        }
    }




}
