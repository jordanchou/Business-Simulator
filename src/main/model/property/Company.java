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
package model.property;

import java.util.*;
import model.property.BankAccount;

public class Company extends Property
{
    private List<String> properties;
    private BankAccount account;

    public Company(String name, String owner, double value, BankAccount account)
    {
        super(name, owner, value);

        this.properties = new ArrayList<String>();
        this.account = account;
    }

    public List<String> getProperties()
    {
        return properties;
    }

    public void addProperty(String property)
    {
        this.properties.add(property);
    }

    public boolean removeProperty(String property)
    {
        return this.properties.remove(property);
    }

    @Override
    public double calcProfit()
    {
        return 0.0;
    }

    @Override
    public double getValue()
    {
        return super.getValue() + account.getValue();
    }

    public String toString()
    {
        return super.toString() + "    Bank: " + account.toString();
    }

    public void buy(Property property)
    {
        account.setValue(account.getValue() - property.getValue());
        addProperty(property.getName());
    }

    public void sell(Property property)
    {
        account.setValue(account.getValue() + property.getValue());
        removeProperty(property.getName());
    }


}