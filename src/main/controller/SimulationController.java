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

    public SimulationController(PropertyManager properties, EventManager events, TransactionManager transactions,
                                    UserInterface ui)
    {
        this.properties = properties;
        this.event = events;
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
        for (int i=start; i<=end; i++)
        {
            //output company names and bank account balances
            ui.outputProperties(properties.getCompanies());

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