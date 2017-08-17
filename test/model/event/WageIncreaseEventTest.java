package model.event;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.WageObserver;

import java.util.List;

import static org.mockito.Mockito.*;

public class WageIncreaseEventTest
{
    @Mock
    List<WageObserver> observers;
    @InjectMocks
    WageIncreaseEvent wageIncreaseEvent;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        wageIncreaseEvent.update();
    }

    @Test
    public void testCompareTo() throws Exception
    {
        int result = wageIncreaseEvent.compareTo(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception
    {
        String result = wageIncreaseEvent.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme