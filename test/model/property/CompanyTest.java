package model.property;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProperty() throws Exception
    {
        company.addProperty(null);
    }

    @Test
    public void testRemoveProperty() throws Exception
    {
        boolean result = company.removeProperty(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testToString() throws Exception
    {
        String result = company.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testBuy() throws Exception
    {
        company.buy(null);
    }

    @Test
    public void testSell() throws Exception
    {
        company.sell(null);
    }

    @Test
    public void testUpdate() throws Exception
    {
        company.update();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme