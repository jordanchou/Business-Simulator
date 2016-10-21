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
    String company;

    public RevenueIncreaseEvent(long year, String company)
    {
        super(year);
        this.company = company;
    }

    public void update(PropertyManager pm)
    {
        BusinessUnit unit = ((BusinessUnit)pm.getProperty(company));

        unit.setRevenue(unit.getRevenue() * 1.05);
    }
}