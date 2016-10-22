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

    public RevenueDecreaseEvent(long year, BusinessUnit unit)
    {
        super(year);
        this.unit = unit;
    }

    public void update()
    {
        unit.setRevenue(unit.getRevenue() * 0.95);
    }
}