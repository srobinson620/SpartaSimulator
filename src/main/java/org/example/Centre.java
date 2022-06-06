package org.example;

import java.util.ArrayList;
import java.util.List;

public class Centre
{
    List<Spartan> SpartanList;

    public int getCentreID()
    {
        return centreID;
    }

    private int centreID;
    Centre(int ID)
    {
        this.centreID=ID;
        this.SpartanList = new ArrayList();
    }
    public void addSpartan(Spartan SpartanToAdd)
    {
        if (this.HasSpace())
        {
            this.SpartanList.add(SpartanToAdd);
        }
    }
    boolean HasSpace() // return true if space available
    {
        return SpartanList.size()<100 ;
    }
    int SpartansInCentre()
    {
           return  SpartanList.size();
    }
}
