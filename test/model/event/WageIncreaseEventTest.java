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

public class WageIncreaseEventTest
{
    List<WageObserver> observers;
    WageObserver wage;

    WageIncreaseEvent wageIncreaseEvent;

    @Before
    public void setUp()
    {
        wage = mock(WageObserver.class);
        MockitoAnnotations.initMocks(this);
        observers = new LinkedList<WageObserver>();

        wageIncreaseEvent = new WageIncreaseEvent(2017,observers);
    }

    @Test
    public void testUpdate() throws Exception
    {
        observers.add(wage);
        wageIncreaseEvent.setObservers(observers);
        wageIncreaseEvent.update();

        verify(wage, times(1)).update(1.05);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme