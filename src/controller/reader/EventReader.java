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

import model.event.*;
import model.property.*;
import controller.*;

import java.util.*;

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
     * @param line the line to process
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
                checkEvent(lineArray);
                event = new RevenueDecreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;

            case "R+":
                if (pm.getProperty(lineArray[2]) == null)
                    throw new IllegalArgumentException("Cannot create event with property: " + lineArray[2]);
                checkEvent(lineArray);
                event = new RevenueIncreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;

            case "W+":
                checkEvent(lineArray);
                event = new WageIncreaseEvent(year, pm.getWageObservers());

                break;

            case "W-":
                checkEvent(lineArray);
                event = new WageDecreaseEvent(year, pm.getWageObservers());
                break;

            case "V+":
                checkEvent(lineArray);
                event = new ValueIncreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;

            case "V-":
                checkEvent(lineArray);
                event = new ValueDecreaseEvent(year, (BusinessUnit)pm.getProperty(lineArray[2]));
                break;
            default:
                throw new IllegalArgumentException("Invalid event type: " + lineArray[1]);
        }

        ec.add(event);
    }

    /**
     * Checks a event line for validity
     * @param line the line to check converted to an array
     */
    private void checkEvent(String[] line)
    {
        if ("".equals(line[0]))
            throw new IllegalArgumentException("Year is empty for event: " + Arrays.toString(line));

        if ("".equals(line[1]))
            throw new IllegalArgumentException("Type is invalid for event: " + Arrays.toString(line));


        if (!('W' == line[1].charAt(0)))
        {
            if (line.length < 2)
                throw new IllegalArgumentException("Property is empty for event: " + Arrays.toString(line) );
        }


    }
}