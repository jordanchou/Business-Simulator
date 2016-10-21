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

import view.*;

public class SimulationController
{
    private PropertyManager properties;
    private EventManager events;
    private TransactionManager transactions;
    private UserInterface ui;

    /**
     *
     */
    public SimulationController()
    {
        properties = null;
        events = null;
        transactions = null;
    }

    /**
     *
     * @param properties
     * @param events
     * @param transactions
     * @param ui
     */
    public SimulationController(PropertyManager properties, EventManager events, TransactionManager transactions,
                                    UserInterface ui)
    {
        this.properties = properties;
        this.events = events;
        this.transactions = transactions;
        this.ui = ui;
    }


    /**
     *
     * @param start  The starting year of the simulation
     * @param end    The ending year of the simulation
     */
    public void simulate(long start, long end)
    {


        for (long i=start; i<=end; i++)
        {
            //output company names and bank account balances
            ui.outputProperties(properties.getCompanies(), i);

            //do events :D
            //give the EventManager the properties as well as the current year
            events.update(properties, i);

            //give the TransactionManager the properties as well as the current year
            transactions.update(properties, i);

            //update bank accounts
            properties.updateAccounts();
        }
    }


}