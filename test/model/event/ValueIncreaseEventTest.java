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

    ValueIncreaseEvent valueIncreaseEvent;

    @Before
    public void setUp()
    {
        unit = mock(BusinessUnit.class);
        MockitoAnnotations.initMocks(this);

        valueIncreaseEvent = new ValueIncreaseEvent(2017,unit);
    }

    @Test
    public void testUpdate() throws Exception
    {
        when(unit.getValue()).thenReturn(100.0);
        valueIncreaseEvent.update();

        Assert.assertEquals(100.0, unit.getValue(), 0.001);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme