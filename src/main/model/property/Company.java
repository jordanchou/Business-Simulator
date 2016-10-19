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

    public Company(String name, String owner, double value, BankAccount account)
    {
        super(name, owner, value);

        this.companies = new ArrayList<String>();
        this.account = account;
    }

    public List<String> getCompanies()
    {
        return companies;
    }

    public void addCompany(String company)
    {
        this.companies.add(company);
    }

    public boolean removeCompany(String company)
    {
        return this.companies.remove(company);
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