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

    public WageIncreaseEvent(long year, List<WageObserver> observers)
    {
        super(year);

        setObservers(observers);
    }

    public void update()
    {
        for (WageObserver observer : observers)
        {
            observer.update(1.05);

        }
    }

    public void setObservers(List<WageObserver> observers)
    {
            this.observers = observers;
    }
}