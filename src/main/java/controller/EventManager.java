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
    EventFactory ef;
    Set<Event> events;


    public EventManager(EventFactory ef, String file)
    {
        this.ef = ef;
        events = new LinkedHashSet<Event>();

        try
        {
            readFile(file);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Invalid events file");
        }

    }

    public void update(PropertyManager properties, long year)
    {
        for (Event event : events)
        {
            if (event.getYear() == year)
            {
                event.update(properties);
            }
            else if (event.getYear() > year)
            {
                break;//change to while-iterator
            }


        }
    }

    private void readFile(String file) throws IOException
    {
        FileInputStream stream = null;
        InputStreamReader streamReader;
        BufferedReader reader;

        try
        {
            stream = new FileInputStream(file);

            streamReader = new InputStreamReader(stream);
            reader = new BufferedReader(streamReader);
            Event event;
            String line;

            line = reader.readLine();
            line = reader.readLine();//Get rid of the first line lol.


            while (line != null)
            {
                event = ef.getEvent(line);
                events.add(event);
                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            if (stream != null)
            {
                try
                {
                    stream.close();
                }
                catch (IOException e2)
                {
                    throw new IOException("wtf");
                }
            }
        }
    }



}
