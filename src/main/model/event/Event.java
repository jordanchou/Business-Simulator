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

public abstract class Event implements Comparable<Event>
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
        if (event.getYear() > this.year)
        {
            return -1;
        }
        else if (event.getYear() < this.year)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}
