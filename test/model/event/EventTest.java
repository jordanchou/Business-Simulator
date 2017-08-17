package model.event;

import org.junit.Assert;
import org.junit.Test;

public class EventTest
{
    Event event = null;

    @Test
    public void testCompareTo() throws Exception
    {
        int result = event.compareTo(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception
    {
        String result = event.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme