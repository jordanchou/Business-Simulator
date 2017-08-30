package model.transaction;

import model.property.Company;
import model.property.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;

import static org.mockito.Mockito.*;

public class SellTransactionTest
{
    @Mock
    Property property;
    @Mock
    Company primary;
    @InjectMocks
    SellTransaction sellTransaction;

    @Before
    public void setUp()
    {
        property = mock(Property.class);
        primary = mock(Company.class);
        sellTransaction = new SellTransaction(2000, property);
        sellTransaction.setPrimary(primary);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateFail() throws Exception
    {
        List list = mock(List.class);

        when(primary.getProperties()).thenReturn(list);
        when (list.contains(property)).thenReturn(false);

        try
        {
            sellTransaction.update();
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
        when (list.contains(property)).thenReturn(true);

        sellTransaction.update();

        verify(primary, times(1)).sell(property);

    }
}
