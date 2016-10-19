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
package controller.factory;

import model.event.*;

public class EventFactory
{
    public EventFactory()
    {

    }

    public Event getEvent(String line)
    {
        String[] lineArray;
        Event event = null;
        long year;

        lineArray = line.split(",");

        year = Long.parseLong(lineArray[0]);

        switch (lineArray[1])
        {
            case "R-":
                event = new RevenueDecreaseEvent(year, lineArray[2]);
                break;

            case "R+":
                event = new RevenueIncreaseEvent(year, lineArray[2]);
                break;

            case "W+":
                event = new WageIncreaseEvent(year);
                break;

            case "W-":
                event = new WageDecreaseEvent(year);
                break;

            case "V+":
                event = new ValueIncreaseEvent(year, lineArray[2]);
                break;

            case "V-":
                event = new ValueDecreaseEvent(year, lineArray[2]);
                break;
            default:
                //throw exception!
        }

        return event;
    }
}