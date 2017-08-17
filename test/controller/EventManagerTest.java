package controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.mockito.Mockito.*;

public class EventManagerTest
{
    @Mock
    Set<Updateable> events;
    @InjectMocks
    EventManager eventManager;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        eventManager.update(0L);
    }

    @Test
    public void testAdd() throws Exception
    {
        eventManager.add(null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme