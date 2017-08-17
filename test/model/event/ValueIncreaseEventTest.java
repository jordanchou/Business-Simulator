package model.event;

import model.property.BusinessUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ValueIncreaseEventTest
{
    @Mock
    BusinessUnit unit;
    @InjectMocks
    ValueIncreaseEvent valueIncreaseEvent;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        valueIncreaseEvent.update();
    }

    @Test
    public void testCompareTo() throws Exception
    {
        int result = valueIncreaseEvent.compareTo(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception
    {
        String result = valueIncreaseEvent.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme