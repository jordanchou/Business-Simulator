package model.event;

import model.property.BusinessUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ValueDecreaseEventTest
{
    @Mock
    BusinessUnit unit;
    @InjectMocks
    ValueDecreaseEvent valueDecreaseEvent;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        valueDecreaseEvent.update();
    }

    @Test
    public void testCompareTo() throws Exception
    {
        int result = valueDecreaseEvent.compareTo(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception
    {
        String result = valueDecreaseEvent.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme