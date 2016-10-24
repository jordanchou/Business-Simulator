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

    /**
     * Constructs a new PropertyManager
     */
    public PropertyManager()
    {
        properties = new LinkedHashMap<String, Property>();
        observers = new ArrayList<WageObserver>();
        primary = null;
    }


    /**
     * Goes through the list of properties and calls update() on them. Updates the profit and interest for each year.
     */
    public void update()
    {
        for (Property property : properties.values())
            property.update();
    }

    /**
     * Retrieves the list of companies for the PropertyManager.
     * @return The list of companies as a List<Property></Property>
     */
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

    /**
     * Retrieves a reference to the primary company
     * @return A reference to the primary company
     */
    public Company getPrimary()
    {
        return primary;
    }

    /**
     * Retrieves a reference to a Property given its name
     * @param name
     * @return
     */
    public Property getProperty(String name)
    {
        return properties.get(name);
    }

    /**
     * Sets the primary company given a reference to it
     * @param primary A reference to a Company
     */
    public void setPrimary(Company primary)
    {
        this.primary = primary;
    }

    /**
     * Adds a property to the PropertyManager. If the property is a BusinessUnit then it is also added to the Observer
     * list
     * @param property The property to add to the PropertyManager
     */
    public void addProperty(Property property)
    {
        properties.put(property.getName(), property);

        if (property instanceof BusinessUnit)
            addObserver((WageObserver)property);
    }

    /**
     * Adds a WageObserver to the list of WageObservers
     * @param observer The observer to add to the list
     */
    private void addObserver(WageObserver observer)
    {
        observers.add(observer);
    }

    /**
     * Retrieves the list of observers for the PropertyManager
     * @return Retrieves the list of WageObservers for the PropertyManager
     */
    public List<WageObserver> getWageObservers()
    {
        return observers;
    }


}


