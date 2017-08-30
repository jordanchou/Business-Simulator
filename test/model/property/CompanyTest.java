package model.property;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;

import java.util.List;

import static org.mockito.Mockito.*;

public class CompanyTest
{
    @Mock
    List<Property> properties;
    @Mock
    BankAccount account;
    @Mock
    Company owner;
    @InjectMocks
    Company company;
    Property property;


    @Before
    public void setUp()
    {
        properties = mock(List.class);
        account = mock(BankAccount.class);
        owner = mock(Company.class);
        company = mock(Company.class);
        property = mock(Property.class);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProperty() throws Exception
    {
        List list = mock(List.class);
        company.addProperty(property);

        verify(list, times(1)).add(property);
    }

    @Test
    public void testRemoveProperty() throws Exception
    {
        when(properties.remove(property)).thenReturn(true);

        boolean result = company.removeProperty(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testBuy() throws Exception
    {
        company.buy(property);
        verify(property, times(1)).setOwner(anyObject());
        verify(company, times(1)).addProperty(property);
    }

    @Test
    public void testSell() throws Exception
    {
        company.sell(property);
        verify(property, times(1)).setOwner(null);
        verify(company, times(1)).removeProperty(property);

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme