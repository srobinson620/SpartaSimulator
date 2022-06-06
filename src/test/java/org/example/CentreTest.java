package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CentreTest {
    Centre centre = new Centre(1);
    @Test
    @DisplayName("Test object creation and ID property for Spartan")
    public void TestSpartansInCentre()
    {
        Assertions.assertEquals(centre.SpartansInCentre(),0);
    }

    @Test
    @DisplayName("Test centre reports one spartan")
    public void TestOneSpartanInCentre()
    {
        Spartan spartan = new Spartan(1);
        centre.addSpartan(spartan);
        Assertions.assertEquals(centre.SpartansInCentre(),1);
    }
    @Test
    @DisplayName("Test Centre HasSpace is false for full centre")
    public void Test100SpartanInCentre()
    {
       for (int x=1;x<=100;x++)
        {
            Spartan spartan = new Spartan(x);
            centre.addSpartan(spartan);
        }
        Assertions.assertEquals(centre.HasSpace(),false);
    }
    @Test
    @DisplayName("Test count for full centre")
    public void TestCountSpartanInCentre()
    {
        for (int x=1;x<=100;x++)
        {
            Spartan spartan = new Spartan(x);
            centre.addSpartan(spartan);
        }
        Assertions.assertEquals(centre.SpartansInCentre(),100);
    }
}
