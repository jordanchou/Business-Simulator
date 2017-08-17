package controller;

import model.property.Company;
import model.property.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.WageObserver;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class PropertyManagerTest
{
    @Mock
    Map<String, Property> properties;
    @Mock
    List<WageObserver> observers;
    @Mock
    Company primary;
    @InjectMocks
    PropertyManager propertyManager;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        propertyManager.update();
    }

    @Test
    public void testGetProperty() throws Exception
    {
        Property result = propertyManager.getProperty("name");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testAddProperty() throws Exception
    {
        propertyManager.addProperty(null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme