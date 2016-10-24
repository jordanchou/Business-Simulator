/*
FILE: Property.java
AUTHOR:Jordan Pinglin Chou
USERNAME:18348691
UNIT: COMP2003 (Object Oriented Software Engineering)
PURPOSE:
REFERENCE:-
COMMENTS:-
REQUIRES:-
*/
package model.property;

public abstract class Property
{
    double value;
    double profit;
    String name;
    Company owner;

    /**
     * Constructs a default Property object
     */
    public Property()
    {
        value = 0.0;
        profit = 0.0;
        name = null;
        owner = null;
    }

    /**
     * Constructs a Property objects using the imported values
     * @param name name of the property
     * @param owner the owner of the property
     * @param value the value of property
     */
    public Property(String name, Company owner, double value)
    {
        this.name = name;
        this.owner = owner;
        this.value = value;
        this.profit = 0.0;
    }

    /**
     * Sets the value of the Property
     * @param value the value to set to
     */
    public void setValue(double value)
    {
        this.value = value;
    }

    /**
     *  Sets the profit of the company
     * @param profit the profit to set
     */
    public void setProfit(double profit)
    {
        this.profit = profit;
    }

    /**
     * Retrieves the value of the company
     * @return the value of the company
     */
    public double getValue()
    {
        return this.value;
    }

    /**
     * Retrieves the name of the company
     * @return the name of the company
     */
    public String getName()
    {
        return name;
    }

    /**
     * Retrieves the owner of the company
     * @return Retrieves a reference of the owner of the company
     */
    public Company getOwner()
    {
        return owner;
    }

    /**
     * Retrieves the profit of the company
     * @return retrieves the the profit of the company
     */
    public double getProfit()
    {
        return profit;
    }

    /**
     * Sets the owner of the company to the imported company
     * @param owner the company to set owner to
     */
    public void setOwner(Company owner)
    {
        this.owner = owner;
    }

    /**
     * Retrieves the state of the company as a string
     * @return a string about the company
     */
    public String toString()
    {
        return "Name: " + name;
    }

    /**
     * Forces subclasses to have an update() method
     */
    public abstract void update();



}