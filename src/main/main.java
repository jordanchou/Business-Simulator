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
import controller.factory.*;
import view.*;

public class Main
{
    public static void main(String[] args)
    {
        PropertyFactory pf = new PropertyFactory();
        EventFactory ef = new EventFactory();
        TransactionFactory tf = new TransactionFactory();

        PropertyManager pm = new PropertyManager(pf, args[1]);
        EventManager em = new EventManager(ef, args[2]);
        TransactionManager tm = new TransactionManager(tf, args[3]);

        UserInterface ui = new UserInterface();

        SimulationController sc = new SimulationController(pm, em, tm, ui);

        long start = Long.parseLong(args[4]);
        long end = Long.parseLong(args[5]);

        sc.simulate(start, end);
    }
}