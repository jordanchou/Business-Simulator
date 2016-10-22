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
package controller;

import java.util.*;
import java.io.*;
import controller.reader.*;
import model.event.*;


public class EventManager
{
    Set<Event> events;

    public EventManager()
    {
        events = new LinkedHashSet<Event>();
    }

    public void update(long year)
    {
        for (Event event : events)
        {
            if (event.getYear() == year)
            {
                event.update();
            }
            else if (event.getYear() > year)
            {
                break;//change to while-iterator
            }


        }
    }

    public void addEvent(Event event)
    {
        events.add(event);
    }

}
