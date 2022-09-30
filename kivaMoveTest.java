
/**
 * Write a description of kivaMoveTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.Point;
public class kivaMoveTest {
    // Define the FloorMap we'll use for all the tests
    String defaultLayout = ""
                         /* x 2,4,6,8,0,2 1 3 */
                         /* y 1,1,1,1,1,1             */
    /* 1  (2,0) */         + "-------------\n"
    /* 2  (2,1) */         + "        P   *\n"
    /* 3  (2,2) */         + "   **       *\n"
    /* 4  (2,3) */         + "   **       *\n"
    /* 5  (2,4) */         + "  K       D *\n"
    /* 6 */                + " * * * * * **\n"
    /* 7 */                + "-------------\n" ;
    
    FloorMap defaultMap = new FloorMap(defaultLayout);
    
    public void testForwardFromUp()
    {
        // GIVEN
        // A Kiva built with the default map we defined earlier 
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        
        // THEN 
        // The Kiva has moved one space up
        verifyKivaState("testForwardFromUp", kiva, new Point (2, 3), FacingDirection.UP, false, false);
    }
    
        public void testForwardwhileFacingLeft()
    {
        // GIVEN
        // A Kiva built with the default map we defined earlier 
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We turn left
        //kiva.move(KivaCommand.TURN_LEFT);
        
        // Or we can turn right (3x)
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        // We move one space to the left
        kiva.move(KivaCommand.FORWARD);
        
        // THEN 
        // The Kiva has moved one space up
        verifyKivaState("testForwardwhileFacingLeft", kiva, new Point (1, 4), FacingDirection.LEFT, false, false);
    }
    
         public void testForwardwhileFacingDown()
    {
        // GIVEN
        // A Kiva built with the default map we defined earlier 
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We turn left (2x)
        //kiva.move(KivaCommand.TURN_LEFT);
        //kiva.move(KivaCommand.TURN_LEFT);
        
        // Or we can turn right (2x)
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        // We move one space backwards
        kiva.move(KivaCommand.FORWARD);
        
        // THEN 
        // The Kiva has moved one space up
        verifyKivaState("testForwardwhileFacingDown", kiva, new Point (2, 5), FacingDirection.DOWN, false, false);
    }
    
     
         public void testForwardwhileFacingRight()
    {
        // GIVEN
        // A Kiva built with the default map we defined earlier 
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We turn left (3x)
        //kiva.move(KivaCommand.TURN_LEFT);
        //kiva.move(KivaCommand.TURN_LEFT);
        //kiva.move(KivaCommand.TURN_LEFT);
        
        // Or we can turn right (1x)
        kiva.move(KivaCommand.TURN_RIGHT);
        // We move one space to the right
        kiva.move(KivaCommand.FORWARD);
        
        // THEN 
        // The Kiva has moved one space up
        verifyKivaState("testForwardwhileFacingRight", kiva, new Point (3, 4), FacingDirection.RIGHT, false, false);
    }
    
         
        public void testTakeOnPod()
    {
        // GIVEN
        // A Kiva built with the default map we defined earlier 
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // Go up three times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // turn right
        kiva.move(KivaCommand.TURN_RIGHT);
        // move right six times (forward)
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        
        // takePod()
        kiva.move(KivaCommand.TAKE);
        
        verifyKivaState("testTakeOnPod", kiva, new Point (8 , 1), FacingDirection.RIGHT, true, false);
    }
    
        public void testDropOnDropZone()
    {
        // GIVEN
        // A Kiva built with the default map we defined earlier 
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // Go up three times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // turn right
        kiva.move(KivaCommand.TURN_RIGHT);
        // move right six times (forward)
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // takePod()
        kiva.move(KivaCommand.TAKE);
        // drop zone location
       // Point dropZone = defaultMap.getDropZoneLocation();
        // move kiva to dropzone (down 3 right two)
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);
        //System.out.println(
                //String.format("Location is %s Expected is %s " , kiva.getCurrentLocation(), new Point(10,4)));
        // The Kiva has moved one space up
        verifyKivaState("testDropOnDropZone", kiva, new Point (10 , 4), FacingDirection.RIGHT, false, true);
    }
    
    public void testMoveOutOfBounds()
    {
        Kiva kiva = new Kiva (defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveOutOfBounds: (expect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
         
        // This only runs if no exception was thrown
        System.out.println("testMoveOutOfBounds FAIL!");
        System.out.println("Moved outside the FloorMap!");
    }
    
        
    public void testMoveIntoObstacle()
    {
        Kiva kiva = new Kiva (defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
         System.out.println("testMoveIntoObstacle: (expect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
  
         
        // This only runs if no exception was thrown
        System.out.println("testMoveIntoObstacle FAIL!");
        System.out.println("Moved into an Obstacle!");
    }
    
     public void testMoveIntoPodWithPod()
    {
        Kiva kiva = new Kiva (defaultMap);
        // Go up three times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // turn right
        kiva.move(KivaCommand.TURN_RIGHT);
        // move right six times (forward)
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // takePod()
        
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println("testMoveIntoPodWithPod: (expect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);

        
        // This only runs if no exception was thrown
        System.out.println("testMoveIntoPodWithPod FAIL!");
        System.out.println("Moved into a POD while carrying a POD!");
    }
    
       public void testTakePodFromWrongLocation()
    {
        Kiva kiva = new Kiva (defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
         System.out.println("testTakePodFromWrongLocation: (expect an NoPodException)");
        kiva.move(KivaCommand.TAKE);
  
         
        // This only runs if no exception was thrown
        System.out.println("testMoveIntoObstacle FAIL!");
        System.out.println("Moved into an Obstacle!");
    }
    
    public void testDropPodInWrongLocation()
    {
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // Go up three times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // turn right
        kiva.move(KivaCommand.TURN_RIGHT);
        // move right six times (forward)
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // takePod()
        kiva.move(KivaCommand.TAKE);
        // drop zone location
       // Point dropZone = defaultMap.getDropZoneLocation();
        // move kiva to dropzone (down 3 right two)
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
         System.out.println("testDropPodInWrongLocation: (expect an IllegalDropZoneException)");
        kiva.move(KivaCommand.DROP);
        
         // This only runs if no exception was thrown
        System.out.println("testDropPodInWrongLocation FAIL!");
        System.out.println("Dropped in Wrong Location, You are fined 10k!");
    
    }
    
        public void testDropPodWithoutAPod()
    {
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // Go up three times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        // turn right
        kiva.move(KivaCommand.TURN_RIGHT);
        // move right six times (forward)
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
      
        // move kiva to dropzone (down 3 right two)
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
         System.out.println("testDropPodWithoutAPod: (expect an NoPodException)");
        kiva.move(KivaCommand.DROP);
        
         // This only runs if no exception was thrown
        System.out.println("testDropPodWithoutAPod FAIL!");
        System.out.println("Dropped a POD without a POD, THat was sneaky!");
    
    }
    
    
    
    // For you: create all the other tests and call verifyKivaState() for each
    
    private boolean sameLocation(Point a, Point b) 
    {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }
    
    private void verifyKivaState(
        String testName,
        Kiva actual,
        Point expectLocation,
        FacingDirection expectDirection,
        boolean expectCarry,
        boolean expectDropped)
    {
        Point actualLocation = actual.getCurrentLocation();
        if (sameLocation(actualLocation, expectLocation))
        {
            System.out.println(
                    String.format("%s: current location SUCCESS", testName));
        } else {
            System.out.println(
                    String.format("%s: current location FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                                expectLocation, actualLocation));
        }
        FacingDirection actualDirection = actual.getDirectionFacing();
        if (actualDirection == expectDirection)
        {
            System.out.println(
                    String.format("%s: facing direction SUCCESS", testName));
        } else {
            System.out.println(
                    String.format("%s: facing direction FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                                expectDirection, actualDirection));
        }
        boolean actualCarry = actual.isCarryingPod();
         if (actualCarry == expectCarry)
        {
            System.out.println(
                    String.format("%s: carrying pod SUCCESS", testName));
        } else {
            System.out.println(
                    String.format("%s: carrying pod FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                                expectCarry, actualCarry));
        }
             boolean actualDropped = actual.isSuccessfullyDropped();
         if (actualDropped == expectDropped)
        {
            System.out.println(
                    String.format("%s: successfully dropped SUCCESS", testName));
        } else {
            System.out.println(
                    String.format("%s: successfully dropped FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                                expectDropped, actualDropped));
        }
    }
}

   

