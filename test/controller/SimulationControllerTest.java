package controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.UserInterface;

import static org.mockito.Mockito.*;

public class SimulationControllerTest
{
    @Mock
    PropertyManager properties;
    @Mock
    EventManager events;
    @Mock
    EventManager transactions;
    @Mock
    UserInterface ui;
    @InjectMocks
    SimulationController simulationController;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSimulate() throws Exception
    {
        simulationController.simulate(0L, 0L);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme