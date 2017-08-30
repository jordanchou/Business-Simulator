package model.property;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BankAccountTest
{
    @InjectMocks
    BankAccount bankAccount;

    @Before
    public void setUp()
    {
        bankAccount = new BankAccount();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception
    {
        bankAccount.setValue(100.0);
        bankAccount.update();
        Assert.assertEquals(105.0, bankAccount.getValue(), 0.001);
    }
}

