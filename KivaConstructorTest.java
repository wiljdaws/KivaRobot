
/**
 * Write a description of KivaConstructorTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.Point;
public class KivaConstructorTest {
    String defaultLayout = ""
                           /* 1 3 5 7 9 1 3 */
    /* 1 */                + "-------------\n"
    /* 2 */                + "        P   *\n"
    /* 3 */                + "   **       *\n"
    /* 4 */                + "   **       *\n"
    /* 5 */                + "  K       D *\n"
    /* 6 */                + " * * * * * **\n"
    /* 7 */                + "-------------\n" ;
    
    FloorMap defaultMap = new FloorMap(defaultLayout);
    
    public void testSingleArgumentConstructor()
    {
        // GIVEN
        // The dafault map we defined earlier
        
        // WHEN
        // We create a Kiva with the single-argument constructor
        Kiva kiva = new Kiva(defaultMap);
        
        // THEN
        // The initial Kiva location is (2,4)
        Point initialLocation = kiva.getCurrentLocation();
        Point expectedLocation = new Point(2,4);
        if (sameLocation(initialLocation, expectedLocation))
        {
            System.out.println("testSingleArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format( "testSingleArgumentConstructor FAIL: %s != (2,4)!" , initialLocation));
        }
    }
    
    public void testTwoArgumentConstructor()
    {
        Kiva kiva = new Kiva(defaultMap, new Point(5,6));
        
        Point currentLocation = kiva.getCurrentLocation();
        Point expectedLocation = new Point(5,6);
        if (sameLocation(currentLocation, expectedLocation))
        {
            System.out.println("testTwoArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format( "testTwoArgumentConstructor FAIL: %s != (5,6)!" , currentLocation));
        }
    }
        
    private boolean sameLocation(Point a, Point b) 
    {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }
    
    // For you: create a test for the constructor taking two arguments
    }
     
     
     
                            

