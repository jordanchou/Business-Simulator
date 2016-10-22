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

    public ValueDecreaseEvent(long year, BusinessUnit unit)
    {
        super(year);
        this.unit = unit;
    }

    public void update()
    {
        unit.setValue(unit.getValue() * 0.95);
    }
}