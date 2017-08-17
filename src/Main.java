/*
FILE: Main.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
import controller.*;
import controller.reader.*;
import view.*;

import java.io.IOException;
import model.error.*;

public class Main
{
    public static void main(String[] args)
    {
        Reader reader;

        PropertyManager pm = new PropertyManager();
        EventManager em = new EventManager();
        EventManager tm = new EventManager();
        UserInterface ui = new UserInterface();

        try
        {
            reader = new PropertyReader(pm);
            reader.readFile(args[0]);

            reader = new EventReader(em, pm);
            reader.readFile(args[1]);

            reader = new TransactionReader(tm, pm);
            reader.readFile(args[2]);

            SimulationController sc = new SimulationController(pm, em, tm, ui);

            long start = Long.parseLong(args[3]);
            long end = Long.parseLong(args[4]);

            sc.simulate(start, end);
        }
        catch (IOException e)
        {
            ui.output(e);
        }
        catch (FileFormatException e)
        {
            ui.output(e);
        }


    }
}