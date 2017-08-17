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

public class ValueDecreaseEvent extends Event
{
    BusinessUnit unit;

    /**
     * Constructs a ValueDecreaseEvent
     * @param year year of the event
     * @param unit the associated BusinessUnit
     */
    public ValueDecreaseEvent(long year, BusinessUnit unit)
    {
        super(year);
        this.unit = unit;
    }

    /**
     * Updates the value of the associated BusinessUnit by -5%
     */
    public void update()
    {
        unit.setValue(unit.getValue() * 0.95);
    }
}