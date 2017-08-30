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
        unit = mock(BusinessUnit.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        when(unit.getRevenue()).thenReturn(100.0);
        revenueIncreaseEvent.update();

        Assert.assertEquals(105.0, unit.getRevenue(), 0.001);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme