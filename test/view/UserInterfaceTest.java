package view;

import model.property.Property;
import org.junit.Test;

import java.util.Arrays;

public class UserInterfaceTest
{
    UserInterface userInterface = new UserInterface();

    @Test
    public void testOutput() throws Exception
    {
        userInterface.output(Arrays.<Property>asList(null), 0L);
    }

    @Test
    public void testOutput2() throws Exception
    {
        userInterface.output(null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme