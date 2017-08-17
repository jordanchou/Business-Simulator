package controller.reader;

import controller.EventManager;
import controller.PropertyManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class EventReaderTest
{
    @Mock
    EventManager ec;
    @Mock
    PropertyManager pm;
    @InjectMocks
    EventReader eventReader;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessLine() throws Exception
    {
        eventReader.processLine("line");
    }

    @Test
    public void testReadFile() throws Exception
    {
        eventReader.readFile("file");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme