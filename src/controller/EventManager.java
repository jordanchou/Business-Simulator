/*
FILE: EventManager.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE: Manages and stores Event objects
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package controller;

import java.util.*;
import java.io.*;
import controller.reader.*;
import model.event.*;


public class EventManager<T>
{
    Set<Updateable> events;

    /**
     * Constructs an EventManager with no events
     */
    public EventManager()
    {
        events = new LinkedHashSet<Updateable>();
    }

    /**
     * Calls the update() method of each Event. Basically carries out the required events for the year
     * @param year
     */
    public void update(long year)
    {
        for (Updateable event : events)
        {
            if (event.getYear() == year)
            {
                event.update();
            }
            else if (event.getYear() > year)//Only do the events for the year
            {
                break;
            }//Do not call remove because unexpected things may happen. Also want to keep the list of events intact
        }
    }

    /**
     * Adds an event to the EventManager
     * @param event The event to add
     */
    public void add(Updateable<T> event)
    {
        for (Updateable e : events)
        {
            if (e.compareTo(event) == 1)//If the event being added is less than the others (in terms of years)
            {
                throw new IllegalArgumentException("Event date is invalid. Please check the years: " + event.toString());

            }
        }

        events.add(event);
    }

}
