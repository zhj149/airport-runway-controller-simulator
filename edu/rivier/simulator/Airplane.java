package edu.rivier.simulator;

/**
 *  Implementation of the Airplane class
 */
 
import java.util.Random;


public class Airplane
{
   private int airplaneNum;
   private AirportServer apServ;
   
   private int requestedRunway; // Picked at random
   private static Random r = new Random( 0 );
   
   // Value constructor for the Airplane class
   public Airplane( int num, AirportServer s )
   {
      airplaneNum = num;
      apServ = s;
      
   } // end Airplane value constructor
   
   
   // Setter method for requestedRunway
   public void setRequestedRunway( int runway )
   {
      requestedRunway = runway;
   }
   
   
   // The run() method in class RunAirplane will call this land() method
   public void land()
   {   
      while ( true )
      {
         // Get ready to land
         requestedRunway = r.nextInt( AirportRunways.NUM_RUNWAYS );
         apServ.reserveRunway( airplaneNum, requestedRunway );
            
         // Landing complete
         apServ.releaseRunway( airplaneNum, requestedRunway );
         
      } // end while
   
   } // end land

} // end class Airplane

