package model.event;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.WageObserver;
import java.util.*;

import java.util.List;

import static org.mockito.Mockito.*;

public class WageDecreaseEventTest
{

    List<WageObserver> observers;

    @Mock
    WageObserver wage;

    WageDecreaseEvent wageDecreaseEvent;

    @Before
    public void setUp()
    {
        wage = mock(WageObserver.class);
        MockitoAnnotations.initMocks(this);
        observers = new LinkedList<WageObserver>();
        wageDecreaseEvent = new WageDecreaseEvent(2017,observers);
    }

    @Test
    public void testUpdate() throws Exception
    {
        observers.add(wage);
        wageDecreaseEvent.setObservers(observers);
        wageDecreaseEvent.update();

        verify(wage, times(1)).update(0.95);
    }

}
