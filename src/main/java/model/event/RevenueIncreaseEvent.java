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

    public RevenueIncreaseEvent(long year, BusinessUnit unit)
    {
        super(year);
        this.unit = unit;
    }

    public void update()
    {
        unit.setRevenue(unit.getRevenue() * 1.05);
    }
}