/*
FILE: Company.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.property;

import java.util.*;
import java.text.*;

public class Company extends Property
{
    private List<Property> properties;
    private BankAccount account;

    /**
     * Constructs a Company using all of the imports
     * @param name Name of the Company
     * @param owner Reference to the owner of the company
     * @param value Value of the company
     * @param account Reference to the Bank Account of the company
     */
    public Company(String name, Company owner, double value, BankAccount account)
    {
        super(name, owner, value);

        this.properties = new ArrayList<Property>();
        this.account = account;
    }

    /**
     * Retrieves the list of properties
     * @return list of properties
     */
    public List<Property> getProperties()
    {
        return properties;
    }

    /**
     * Adds a property to the map of properties
     * @param property the property to add
     */
    public void addProperty(Property property)
    {
        this.properties.add(property);
    }

    /**
     * Removes a property from the map of properties
     * @param property the property to remove
     * @return true or false depending on if the property can be removed on not
     */
    public boolean removeProperty(Property property)
    {
        return this.properties.remove(property);
    }

    /**
     * Retrieves the value of the property
     * @return value of the property
     */
    @Override
    public double getValue()
    {
        return super.getValue() + account.getValue();
    }

    /**
     * Retrieves the string representation of the Property
     * @return the state of the Property
     */
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return (super.toString() + "    " +  df.format(account.getValue()));
    }

    /**
     * Invokes/simulates the buying of a property by adjusting the values of the properties
     * @param property the property to buy
     */
    public void buy(Property property)
    {
        account.setValue(account.getValue() - property.getValue());//check ownership
        property.setOwner(this);
        addProperty(property);
    }

    /**
     * Invokes/simulates the selling of a property by adjusting the values of the properties
     * @param property the property to sell
     */
    public void sell(Property property)
    {
        account.setValue(account.getValue() + property.getValue());//check ownership
        property.setOwner(null);
        removeProperty(property);
    }

    /**
     * Updates the profits of all companies that this one owns
     */
    @Override
    public void update()
    {
        double profit = 0.0;

        for (Property property : properties)
        {
            //if (!("".equals(property.getOwner())))
            property.update();
            profit = profit + property.getProfit();
        }


        if (profit >= 0.0)
            account.setValue(account.getValue() + 0.5 * profit);
        else
            account.setValue(account.getValue() - profit);

        account.update();//Calculate the interest
    }


}