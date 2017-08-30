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
        owner = mock(Company.class);
        businessUnit = new BusinessUnit(null, null, 100, 100, 100);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateWages() throws Exception
    {
        businessUnit.update(0.5);
        Assert.assertEquals(50.0, businessUnit.getWages(), 0.001);
    }

    @Test
    public void testUpdateProfits() throws Exception
    {
        businessUnit.update();
        Assert.assertEquals(0.0, businessUnit.getProfit(), 0.001);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme