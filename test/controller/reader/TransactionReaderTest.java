package controller.reader;

import controller.EventManager;
import controller.PropertyManager;
import model.property.*;
import model.transaction.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TransactionReaderTest
{
    @Mock
    EventManager tm;
    @Mock
    PropertyManager pm;
    @Mock
    Property property;
    @Mock
    Company company;
    @InjectMocks
    TransactionReader transactionReader;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        when(pm.getProperty("Cannington")).thenReturn(property);
        when(pm.getPrimary()).thenReturn(company);
    }

    @Test
    public void testProcessLineBuy() throws Exception
    {
        transactionReader.processLine("2017,S,Cannington");
        verify(tm, times(1)).add(any(BuyTransaction.class));
    }

    @Test
    public void testProcessLineSell() throws Exception
    {
        transactionReader.processLine("2017,B,Cannington");
        verify(tm, times(1)).add(any(SellTransaction.class));

    }

}