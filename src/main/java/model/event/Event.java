/*
FILE: Event.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.event;

import java.util.*;
import controller.*;
import model.property.*;

public abstract class Event implements Comparable<Event>, Updateable<Event>
{
    private long year;

    public Event()
    {
        year = -1;
    }

    public Event(long year)
    {
        setYear(year);
    }

    public long getYear()
    {
        return this.year;
    }

    public void setYear(long year)
    {
        if (!validateYear(year))
            throw new IllegalArgumentException("Invalid year: " + year);

        this.year = year;
    }

    private boolean validateYear(long year)
    {
        return year > 0;
    }

    public int compareTo(Event event)
    {
        int value;

        if (event.getYear() > this.year)
        {
            value =  -1;
        }
        else if (event.getYear() < this.year)
        {
            value = 1;
        }
        else
        {
            value = 0;
        }

        return value;
    }

    /**
     * Returns the state of the Event as a String
     * @return state of the Event
     */
    public String toString()
    {
        return year + "";
    }

    /**
     * Abstract update() method
     */
    public abstract void update();

}
