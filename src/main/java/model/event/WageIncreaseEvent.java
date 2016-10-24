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
package model.event;

import controller.*;
import model.property.*;
import view.WageObserver;

import java.util.List;

public class WageIncreaseEvent extends Event
{
    List<WageObserver> observers;

    /**
     * Constructs a WageIncreaseEvent
     * @param year the year of the event
     * @param observers list of observers
     */
    public WageIncreaseEvent(long year, List<WageObserver> observers)
    {
        super(year);

        setObservers(observers);
    }

    /**
     * Calls the update() method on each of the observers in the list
     */
    public void update()
    {
        for (WageObserver observer : observers)
        {
            observer.update(1.05);

        }
    }

    /**
     * Sets the observers for the Event
     * @param observers the observers that this event should have
     */
    public void setObservers(List<WageObserver> observers)
    {
            this.observers = observers;
    }
}