package model.transaction;

import model.property.Company;
import model.property.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

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
        property = mock(Property.class);
        primary = mock(Company.class);
        buyTransaction = new BuyTransaction(2000, property);
        buyTransaction.setPrimary(primary);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateFail() throws Exception
    {
        List list = mock(List.class);

        when(primary.getProperties()).thenReturn(list);
        when (list.contains(property)).thenReturn(true);

        try
        {
            buyTransaction.update();
        }
        catch (IllegalStateException e)
        {
        }

    }

    @Test
    public void testUpdateNormal() throws Exception
    {
        List list = mock(List.class);

        when(primary.getProperties()).thenReturn(list);
        when (list.contains(property)).thenReturn(false);

        buyTransaction.update();

    }

}
