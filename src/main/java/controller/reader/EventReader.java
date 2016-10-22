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
package controller.reader;

import model.event.*;
import model.property.*;
import controller.*;
import model.property.Property;

public class EventReader extends Reader
{
    EventManager ec;
    PropertyManager pm;

    public EventReader(EventManager eventController, PropertyManager pm)
    {
        this.ec = eventController;
        this.pm = pm;
    }

    @Override
    public void processLine(String line)
    {
        String[] lineArray;
        Event event = null;
        long year;

        lineArray = line.split(",");

        year = Long.parseLong(lineArray[0]);

        switch (lineArray[1])
        {
            case "R-":
                event = new RevenueDecreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;

            case "R+":
                event = new RevenueIncreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;

            case "W+":
                event = new WageIncreaseEvent(year, pm.getWageObservers());

                break;

            case "W-":
                event = new WageDecreaseEvent(year, pm.getWageObservers());
                break;

            case "V+":
                event = new ValueIncreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;

            case "V-":
                event = new ValueDecreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;
            default:
                //throw exception!
        }

        ec.addEvent(event);
    }
}