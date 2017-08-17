package controller.reader;

import controller.PropertyManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class PropertyReaderTest
{
    @Mock
    PropertyManager properties;
    @InjectMocks
    PropertyReader propertyReader;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessLine() throws Exception
    {
        propertyReader.processLine("line");
    }

    @Test
    public void testCheckCompany() throws Exception
    {
        propertyReader.checkCompany(new String[]{"lineArray"});
    }

    @Test
    public void testCheckBusinessUnit() throws Exception
    {
        propertyReader.checkBusinessUnit(new String[]{"lineArray"});
    }

    @Test
    public void testReadFile() throws Exception
    {
        propertyReader.readFile("file");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme