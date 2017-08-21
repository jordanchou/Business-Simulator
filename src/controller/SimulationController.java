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
    private EventManager transactions;
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
    public SimulationController(PropertyManager properties, EventManager events, EventManager transactions,
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

          try
          {
              for (long i = start; i <= end; i++)
              {
                  //output company names and bank account balances
                  ui.update(properties.getCompanies(), i);



                  //do events :D
                  //give the EventManager the properties as well as the current year
                  events.update(i);

                  //give the TransactionManager the properties as well as the current year
                  this.transactions.update(i);

                  //update bank accounts
                  properties.update();
              }

              ui.run();
          }
          catch (IllegalArgumentException e)
          {
              ui.output(e);
          }
          catch (IllegalStateException e)
          {
              ui.output(e);
          }

    }


}