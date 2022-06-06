package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    //  System.out.println( "Hello World!" );
    {
        Scanner keyboard = new Scanner(System.in);
        boolean errorHappened=true;
        while (errorHappened)
        {
            errorHappened=false;
            Tracker tracker = new Tracker();
            System.out.println("Simulate How many months? ");
            try
            {
                tracker.SetMonths(keyboard.nextInt());
                tracker.RunSimulation();
            }
            catch (Exception e)
            {
                System.out.println("Looks like there was a problem with the value you entered! ");
                System.out.println("Error " + e.getMessage());
                errorHappened=true;
            }
            String x = keyboard.next();
        }
    }

    public static class SpartanManager
    //creates or removes spartan objects and returns them as a list
    {
        static int totalSpartans=0;
        static ArrayList<Spartan> waitingList= new ArrayList<Spartan>();
        static Random random = new Random();
        static ArrayList<Spartan> GetSpartans()
        {
            int randomSpartansRecruited = random.nextInt(99)+1 ; // random recruits between 1 and 100
            ArrayList<Spartan> newSpartanList = new ArrayList<Spartan>();
            for (int x=1; x<= randomSpartansRecruited; x++)
            {
                totalSpartans++;
                Spartan newSpartan = new Spartan(totalSpartans);
                newSpartanList.add(newSpartan);
            }
            System.out.println("New Spartans "+(Integer.toString(newSpartanList.size())));
            return newSpartanList;
        }
        static public boolean SpartansAvailable()
        {
            return waitingList.size()>0;
        }
        static public Spartan GetSpartanFromList()
        {
            Spartan SpartanFromList = waitingList.get(0);
            waitingList.remove(0);
            return SpartanFromList;
        }
    }

    public static class CentreManager
    {
        static int totalCentres=0;
        static ArrayList<Centre> CentreList= new ArrayList<Centre>();
        static Centre GetCentre()
        {
            totalCentres++ ;
            Centre NewCentre= new Centre(totalCentres);
            return NewCentre;
        }
    }

    public static class Tracker
        //Loops through months making events occur
    {
        private int simulationTime = 1;
        boolean SetMonths (int months)
        {
            if (months >= 1)
            {
                this.simulationTime = months;
                return  true;
            }
            else
            {
                return false;
            }
        }

        public void RunSimulation()
        {
            for (int monthIndex=1;monthIndex<=simulationTime;monthIndex++)
            {
                System.out.println("Month "+(Integer.toString(monthIndex)));
                if (monthIndex % 2==1) //add centre only odd months
                {
                    CentreManager.CentreList.add(CentreManager.GetCentre());
                }
                SpartanManager.waitingList.addAll(SpartanManager.GetSpartans()); // put spartans on waiting list
                for (Centre CentreToProcess:CentreManager.CentreList)
                {
                    while (CentreToProcess.HasSpace() && SpartanManager.SpartansAvailable())
                    {
                        CentreToProcess.addSpartan(SpartanManager.GetSpartanFromList());
                    }
                    System.out.println("-----processing Centre: "+ Integer.toString(CentreToProcess.getCentreID()));
                    System.out.println("---------Spartans in centre: "+Integer.toString(CentreToProcess.SpartansInCentre()));
                }
                System.out.println("Spartans waiting "+(Integer.toString(SpartanManager.waitingList.size())));
            }
        }
    }
}
