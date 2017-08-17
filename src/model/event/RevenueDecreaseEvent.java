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

public class RevenueDecreaseEvent extends Event
{
    BusinessUnit unit;

    /**
     * Constructs a RevenueDecreaseEvent
     * @param year year for the Event
     * @param unit unit that the Event applies to
     */
    public RevenueDecreaseEvent(long year, BusinessUnit unit)
    {
        super(year);
        this.unit = unit;
    }

    /**
     * Updates the revenue of the associated BusinessUnit by -5%
     */
    public void update()
    {
        unit.setRevenue(unit.getRevenue() * 0.95);
    }

}