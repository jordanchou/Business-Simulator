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
package model.event;

import controller.*;
import model.property.*;

public class WageIncreaseEvent extends Event
{
    public WageIncreaseEvent(long year)
    {
        super(year);
    }

    public void update(PropertyManager pm)
    {
        pm.notifyObservers(1.05);
    }
}