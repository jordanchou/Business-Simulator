package controller.reader;

import controller.EventManager;
import controller.PropertyManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import model.event.*;
import model.property.*;
import java.util.*;

import static org.mockito.Mockito.*;

public class EventReaderTest
{
    Event event;
    @Mock
    EventManager ec;
    @Mock
    PropertyManager pm;
    @InjectMocks
    EventReader eventReader;
    BusinessUnit property;

    @Before
    public void setUp()
    {
        ec = mock(EventManager.class);
        pm = mock(PropertyManager.class);
        property = mock(BusinessUnit.class);

        when(pm.getProperty("Bakers")).thenReturn(property);

        eventReader = new EventReader(ec, pm);
    }

    @Test
    public void testProcessLineRevenueDec() throws Exception
    {
        eventReader.processLine("2017,R-,Bakers");
        verify(ec, times(1)).add(isA(RevenueDecreaseEvent.class));
    }

    @Test
    public void testProcessLineRevenueInc() throws Exception
    {
        eventReader.processLine("2017,R+,Bakers");
        verify(ec, times(1)).add(isA(RevenueIncreaseEvent.class));
    }

    @Test
    public void testProcessLineValueInc() throws Exception
    {
        eventReader.processLine("2017,V+,Bakers Street");
        verify(ec, times(1)).add(isA(ValueIncreaseEvent.class));
    }

    @Test
    public void testProcessLineValueDec() throws Exception
    {
        eventReader.processLine("2017,V-,Bakers Street");
        verify(ec, times(1)).add(isA(ValueDecreaseEvent.class));
    }

    @Test
    public void testProcessLineWageInc() throws Exception
    {
        eventReader.processLine("2017,W+,");
        verify(ec, times(1)).add(isA(WageIncreaseEvent.class));
    }

    @Test
    public void testProcessLineWageDec() throws Exception
    {
        eventReader.processLine("2017,W-,");
        verify(ec, times(1)).add(isA(WageDecreaseEvent.class));
    }
}