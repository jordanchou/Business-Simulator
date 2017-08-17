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

import model.property.*;
import controller.*;

public class RevenueIncreaseEvent extends Event
{
    BusinessUnit unit;

    /**
     * Constructs a RevenueIncreaseEvent
     * @param year year for the Event
     * @param unit unit that the Event applies to
     */
    public RevenueIncreaseEvent(long year, BusinessUnit unit)
    {
        super(year);
        this.unit = unit;
    }

    /**
     * Updates the revenue of the associated BusinessUnit by +5%
     */
    public void update()
    {
        unit.setRevenue(unit.getRevenue() * 1.05);
    }
}