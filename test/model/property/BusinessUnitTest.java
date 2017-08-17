package model.property;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BusinessUnitTest
{
    @Mock
    Company owner;
    @InjectMocks
    BusinessUnit businessUnit;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        businessUnit.update(0d);
    }

    @Test
    public void testUpdate2() throws Exception
    {
        businessUnit.update();
    }

    @Test
    public void testToString() throws Exception
    {
        String result = businessUnit.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme