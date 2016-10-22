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
        PropertyReader pf = new PropertyReader();
        EventFactory ef = new EventFactory();
        TransactionReader tf = new TransactionReader();

        PropertyManager pm = new PropertyManager(pf, args[0]);
        EventManager em = new EventManager(ef, args[1]);
        TransactionManager tm = new TransactionManager(tf, args[2]);

        UserInterface ui = new UserInterface();

        SimulationController sc = new SimulationController(pm, em, tm, ui);

        long start = Long.parseLong(args[3]);
        long end = Long.parseLong(args[4]);

        sc.simulate(start, end);
    }
}