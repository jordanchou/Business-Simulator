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

    RevenueIncreaseEvent revenueIncreaseEvent;

    @Before
    public void setUp()
    {
        unit = mock(BusinessUnit.class);
        MockitoAnnotations.initMocks(this);

        revenueIncreaseEvent = new RevenueIncreaseEvent(2017, unit);
    }

    @Test
    public void testUpdate() throws Exception
    {
        when(unit.getRevenue()).thenReturn(100.0);
        revenueIncreaseEvent.update();

        Assert.assertEquals(100.0, unit.getRevenue(), 0.001);
    }

}

 