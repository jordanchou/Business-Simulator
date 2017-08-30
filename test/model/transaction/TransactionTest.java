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

public class TransactionTest
{
    @Mock
    Property property;
    @Mock
    Company primary;
    @InjectMocks
    Transaction transaction;

    @Before
    public void setUp()
    {
        property = mock(Property.class);
        primary = mock(Company.class);
        transaction = new BuyTransaction(2000, property);
        transaction.setPrimary(primary);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCompareTo() throws Exception
    {
        int result = transaction.compareTo(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception
    {
        when(property.toString()).thenReturn("testProperty");
        when(primary.toString()).thenReturn("testPrimary");
        String result = transaction.toString();
        Assert.assertEquals("Transaction: year=2000, property=testProperty, primary=testPrimary", result);
    }
}
