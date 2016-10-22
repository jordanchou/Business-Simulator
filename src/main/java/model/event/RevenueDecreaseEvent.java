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
    String company;

    public RevenueDecreaseEvent(long year, String company)
    {
        super(year);
        this.company = company;
    }

    public void update(PropertyManager pm)
    {
        BusinessUnit unit = ((BusinessUnit)pm.getProperty(company));
        unit.setRevenue(unit.getRevenue() * 0.95);
    }
}