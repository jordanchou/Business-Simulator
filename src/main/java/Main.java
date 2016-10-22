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
import controller.*;
import controller.reader.*;
import view.*;

public class Main
{
    public static void main(String[] args)
    {
        Reader reader;

        PropertyManager pm = new PropertyManager();
        EventManager em = new EventManager();
        TransactionManager tm = new TransactionManager();

        try
        {
            reader = new PropertyReader(pm);
            reader.readFile(args[0]);

            reader = new EventReader(em, pm);
            reader.readFile(args[1]);

            reader = new TransactionReader(tm, pm);
            reader.readFile(args[2]);
        }
        catch (Exception lolpleasechangethis)
        {

        }

        UserInterface ui = new UserInterface();

        SimulationController sc = new SimulationController(pm, em, tm, ui);

        long start = Long.parseLong(args[3]);
        long end = Long.parseLong(args[4]);

        sc.simulate(start, end);
    }
}