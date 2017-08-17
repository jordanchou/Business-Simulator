package controller.reader;

import controller.EventManager;
import controller.PropertyManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TransactionReaderTest
{
    @Mock
    EventManager tm;
    @Mock
    PropertyManager pm;
    @InjectMocks
    TransactionReader transactionReader;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessLine() throws Exception
    {
        transactionReader.processLine("line");
    }

    @Test
    public void testCheckTransaction() throws Exception
    {
        transactionReader.checkTransaction(new String[]{"lineArray"});
    }

    @Test
    public void testReadFile() throws Exception
    {
        transactionReader.readFile("file");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme