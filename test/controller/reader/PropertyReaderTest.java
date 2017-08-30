package controller.reader;

import controller.PropertyManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import model.property.*;

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
        properties = mock(PropertyManager.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessLineCompany() throws Exception
    {
        propertyReader.processLine("Giblet Inc,C,,750000");
        verify(properties, times(1)).addProperty(isA(Company.class));
    }

    @Test
    public void testProcessLineBusinessUnit() throws Exception
    {
        propertyReader.processLine("Cannington factory,B,,50000,100,500");
        verify(properties, times(1)).addProperty(isA(BusinessUnit.class));
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme