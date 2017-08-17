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

import controller.*;

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

    /**
     * Retrieves the year
     * @return the year of the event as a long
     */
    public long getYear()
    {
        return this.year;
    }

    /**
     * Sets the year of the event to the imported year
     * @param year a year as a long
     */
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

    /**
     * Compares two events to see how close they are
     * @param event the event to compare
     * @return 0, 1 or -1 depending on how close the events are
     */
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
