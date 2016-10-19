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
    private List<String> companies;
    private BankAccount account;

    public Company(String name, double value, List<String> companies, BankAccount account)
        {
            super(name, value);

        this.companies = companies;
        this.account = account;
    }

    public List<String> getCompanies()
    {
        return companies;
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


}