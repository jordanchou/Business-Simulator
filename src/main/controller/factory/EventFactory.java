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
package controller.factory;

import model.event.*;

public class EventFactory
{
    public EventFactory()
    {

    }

    public Event getEvent(String line)
    {
        String[] lineArray;
        Event event;

        lineArray = line.split(",");

        switch (lineArray[1])
        {
            case "R-":

                break;

            case "R+":

                break;

            case "W+":

                break;

            case "W-":

                break;

            case "V+":

                break;

            case "V-":

                break;
        }



        return null;
    }
}