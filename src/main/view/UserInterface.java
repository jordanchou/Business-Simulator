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

public class UserInterface
{
    public UserInterface()
    {

    }

    public void outputProperties(List<Property> properties)
    {
        for (Property property : properties)
            System.out.println(property.toString());
    }
}