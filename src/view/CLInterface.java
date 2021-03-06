/*
FILE: UserInterface.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package view;

import java.util.*;
import model.property.*;

public class CLInterface implements UserInterface
{
    /**
     * Constructs a UserInterface
     */
    public CLInterface()
    {
    }

    /**
     * Outputs the current year as well as a list of properties
     * @param properties a list of properties to output
     * @param year the year to output
     */
    public void update(List<Company> properties, long year)
    {
        System.out.println("Year: " + year);

        for (Company property : properties)
            System.out.println(property.toString());

        System.out.println();
    }

    public void run()
    {

    }

    public void output(Exception e)
    {
        System.out.println(e.getMessage());
    }
}