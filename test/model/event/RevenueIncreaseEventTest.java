package model.event;

import model.property.BusinessUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class RevenueIncreaseEventTest
{
    @Mock
    BusinessUnit unit;
    @InjectMocks
    RevenueIncreaseEvent revenueIncreaseEvent;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        revenueIncreaseEvent.update();
    }

    @Test
    public void testCompareTo() throws Exception
    {
        int result = revenueIncreaseEvent.compareTo(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception
    {
        String result = revenueIncreaseEvent.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme