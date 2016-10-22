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
import java.text.*;

public class Company extends Property
{
    private List<Property> properties;
    private BankAccount account;

    public Company(String name, Company owner, double value, BankAccount account)
    {
        super(name, owner, value);

        this.properties = new ArrayList<Property>();
        this.account = account;
    }

    public List<Property> getProperties()
    {
        return properties;
    }

    public void addProperty(Property property)
    {
        this.properties.add(property);
    }

    public boolean removeProperty(Property property)
    {
        return this.properties.remove(property);
    }

    @Override
    public double getValue()
    {
        return super.getValue() + account.getValue();
    }

    public String toString()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return (super.toString() + "    " +  df.format(account.getValue()));
    }

    public void buy(Property property)
    {
    //System.out.println("PROPERTY BUYING IS: " + property.getName() + " VALUE IS: " + property.getValue());
        account.setValue(account.getValue() - property.getValue());
        property.setOwner(this);
        addProperty(property);
    }

    public void sell(Property property)
    {
        //System.out.println("PROPERTY SELLING IS: " + property.getName() + " VALUE IS: " + property.getValue());
        account.setValue(account.getValue() + property.getValue());
        property.setOwner(null);
        removeProperty(property);
    }

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

        account.update();
    }


}