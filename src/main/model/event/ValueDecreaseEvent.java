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
    String company;

    public ValueDecreaseEvent(long year, String company)
    {
        super(year);
        this.company = company;
    }

    public void update(PropertyManager pm)
    {
        Property unit = pm.getProperty(company);

        unit.setValue(unit.getValue() * 0.95);
    }
}