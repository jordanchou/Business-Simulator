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

import java.util.*;
import model.property.*;
import view.*;

public class PropertyManager
{
    Map<String, Property> properties;
    List<WageObserver> observers;
    Company primary;

    public PropertyManager()
    {
        properties = new LinkedHashMap<String, Property>();
        observers = new ArrayList<WageObserver>();
        primary = null;
    }


    public void update()
    {
        for (Property property : properties.values())
            property.update();
    }

    public List<Property> getCompanies()
    {
        List<Property> companies;

        companies = new ArrayList<Property>();

        for (Property property : properties.values())
        {
            if (property instanceof Company)
                companies.add(property);
        }

        return companies;
    }


    public Company getPrimary()
    {
        return primary;
    }

    public Property getProperty(String name)
    {
        return properties.get(name);
    }

    public void setPrimary(Company primary)
    {
        this.primary = primary;
    }

    public void addProperty(Property property)
    {
        properties.put(property.getName(), property);

        if (property instanceof BusinessUnit)
            addObserver((BusinessUnit)property);//don't hate me dave
    }

    private void addObserver(WageObserver observer)
    {
        observers.add(observer);
    }

    public List<WageObserver> getWageObservers()
    {
        return observers;
    }


}
