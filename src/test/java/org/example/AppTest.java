package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
//    @BeforeAll

    @Test
    @DisplayName("Test object creation and ID property for Spartan")
    public void testSpartanID()
    {
        Spartan spartan = new Spartan(1);
        Assertions.assertEquals(spartan.getSpartanID(),1);
    }

}
