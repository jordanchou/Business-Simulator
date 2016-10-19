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
public abstract class Event
{
    private int year;

    public Event()
    {
        year = -1;
    }

    public Event(int year)
    {
        setYear(year);
    }

    public int getYear()
    {
        return this.year;
    }

    public void setYear(int year)
    {
        if (validateYear(year))
            this.year = year;
    }

    private boolean validateYear(int year)
    {
        return year > 0;
    }

}
