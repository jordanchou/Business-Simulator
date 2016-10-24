/*
FILE: EventReaderjava
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE: Reads in Event objects from file
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package controller.reader;

import model.error.FileFormatException;
import model.event.*;
import model.property.*;
import controller.*;
import model.property.Property;

public class EventReader extends Reader
{
    EventManager ec;
    PropertyManager pm;

    /**
     * Constructs a EventReader with an EventController and a PropertyManager
     * @param eventController EventController to add events to
     * @param pm              PropertyManager to add property references to Events
     */
    public EventReader(EventManager eventController, PropertyManager pm)
    {
        this.ec = eventController;
        this.pm = pm;
    }

    /**
     * Overrides the abstract processLine method from Reader. This method processes a line and adds it to the
     * EventManager
     * @param line
     */
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
                if (pm.getProperty(lineArray[2]) == null)
                    throw new IllegalArgumentException("Cannot create event with property: " + lineArray[2]);
                event = new RevenueDecreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;

            case "R+":
                if (pm.getProperty(lineArray[2]) == null)
                    throw new IllegalArgumentException("Cannot create event with property: " + lineArray[2]);
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
                throw new IllegalArgumentException("Invalid event type: " + lineArray[1]);
        }

        ec.add(event);
    }
}