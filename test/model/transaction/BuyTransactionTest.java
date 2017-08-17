package model.transaction;

import model.property.Company;
import model.property.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BuyTransactionTest
{
    @Mock
    Property property;
    @Mock
    Company primary;
    @InjectMocks
    BuyTransaction buyTransaction;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        buyTransaction.update();
    }

    @Test
    public void testCompareTo() throws Exception
    {
        int result = buyTransaction.compareTo(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception
    {
        String result = buyTransaction.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme