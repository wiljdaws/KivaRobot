
/**
* <h1>Kiva robot</h1>
* The Kiva program implements an application that
* moves a robot through a map avoiding obstacles, 
* picking up a pod and dropping at the correct location
* (through user input). If a move off the map, into an obstacle 
* or any invalid move is made an exception will be thrown.
* <p>
* <b>Note:</b> Try creating your own maps!.
*
* @author  Dawson Williams
* @version 1.0
* @since   2022-06-01
*/
import edu.duke.Point;
public class Kiva {
private Point currentLocation;
private FacingDirection directionFacing;
private FloorMap map;
private boolean carryingPod;
private boolean successfullyDropped;
private FloorMapObject object;
private int widthOfMap;
private int heightOfMap;
private int indexOfKiva;
private long motorLifetime;

  /**
   * This method is used to initialize the instance variables of the Kiva class. This is
   * a the simplest form of a class method, just to show the usage of various javadoc Tags.
   * @param map This is a FloorMap named map which is initialized in a tester method as a default String.
   *        This is how you set up your obstacles, Kiva location, DropZone, and POD locations.
   */
  
public Kiva(FloorMap map)
{
    this.map = map;
    this.currentLocation = map.getInitialKivaLocation();
    this.directionFacing= directionFacing.UP;
    this.heightOfMap = map.getMaxRowNum();
    this.widthOfMap = map.getMaxColNum();
    this.carryingPod = false;
    this.successfullyDropped = false;
    this.indexOfKiva = map.toString().indexOf("K");
    this.motorLifetime = 0;
    //System.out.println( 
    //String.format("Width of map is %s, height of map is %s, kiva is facing %s, and is at point %s. Kiva index is %s ", widthOfMap, heightOfMap, directionFacing, currentLocation, indexOfKiva));
}

public Kiva(FloorMap map, Point currentLocation)
{
    //check if ↓ new Kiva(map) works if not just use this.map = map;
    Kiva kiv = new Kiva(map);
    this.currentLocation = currentLocation;
}

public Point getCurrentLocation()
{
    return currentLocation;
}

public long getMotorLifetime()
{
    return motorLifetime;
}

public FacingDirection getDirectionFacing()
{
    return directionFacing;
}

private void incrementMotorLifetime()
{
    this.motorLifetime += 1000;
}

public void move(KivaCommand command)
{
    //int x = this.currentLocation.getX();
    //int y = this.currentLocation.getY();
    if(command == KivaCommand.FORWARD){
        moveForward();
        incrementMotorLifetime();
        System.out.println(String.format("Kiva is at point %s. (T/F) Kiva has POD: %s, (T/F) Kiva has succesfully dropped POD: %s ",  currentLocation, carryingPod, successfullyDropped));
        System.out.println(map);
    } else if(command == KivaCommand.TURN_LEFT){
        turnLeft();
        incrementMotorLifetime();
        System.out.println(String.format(" \t \t Kiva is now facing %s.", directionFacing));
    } else if(command == KivaCommand.TURN_RIGHT){
        turnRight();
        incrementMotorLifetime();
        System.out.println(String.format(" \t \t Kiva is now facing %s.", directionFacing));
    } else if(command == KivaCommand.TAKE){
        takePod();
        System.out.println(String.format("Kiva goes to pick up POD... (T/F) Kiva has POD: %s, (T/F) Kiva has succesfully dropped POD: %s ", carryingPod, successfullyDropped));
    } else if(command == KivaCommand.DROP){
        dropPod();
        System.out.println(String.format("Kiva goes to drop off POD... (T/F) Kiva has POD: %s, (T/F) Kiva has succesfully dropped POD: %s ", carryingPod, successfullyDropped));
    }
}

private void moveForward()
{
    int x = this.currentLocation.getX();
    int y = this.currentLocation.getY();
    int tempX = 0;
    int tempY = 0;
    StringBuilder sb = new StringBuilder(map.toString());
        if (this.directionFacing == directionFacing.UP)
    {
        tempY = y - 1;
        
             if( tempY < 0 || tempY > heightOfMap){
                      throw new IllegalMoveException(
                                String.format("I'm sorry you cant move that direction, try turning. Current location is %s, max height for map is %s ", this.currentLocation, heightOfMap));
                    } else{
                        if(map.getObjectAtLocation(new Point (x,tempY) ) == object.OBSTACLE){
                            throw new IllegalMoveException(
                                    String.format("Ouch that hurt, seems like you ran me into a %s, at %s try turning please.", map.getObjectAtLocation(new Point(x, tempY)), new Point(x, tempY)));
                        } else if (this.carryingPod == true && map.getObjectAtLocation(new Point (x,tempY) ) == object.POD){
                            throw new IllegalMoveException(
                                    String.format("Thats too heavy, can only carry one POD at a time, try turning or dropping your load first. (T/F) Kiva has POD: %s", carryingPod));
                        } else{
                                this.currentLocation = new Point (x,tempY);
                            }
                        }  
        
    } else if (this.directionFacing == directionFacing.LEFT)
        {
            tempX = x - 1;
            
                if( tempX < 0 || tempX > widthOfMap){                
                          throw new IllegalMoveException(
                                    String.format("I'm sorry you cant move that direction, try turning. Current location is %s, max width for map is %s ", this.currentLocation, widthOfMap));
                    } else{
                        if(map.getObjectAtLocation(new Point (tempX,y) ) == object.OBSTACLE){
                        throw new IllegalMoveException(
                                     String.format("Ouch that hurt, seems like you ran me into a %s, try turning please.", map.getObjectAtLocation(new Point(tempX, y))));
                        } else if (this.carryingPod == true && map.getObjectAtLocation(new Point (tempX,y) ) == object.POD){
                            throw new IllegalMoveException(
                                    String.format("Thats too heavy, can only carry one POD at a time, try turning or dropping your load first. (T/F) Kiva has POD: %s", carryingPod));
                        } else{ 
                                this.currentLocation = new Point (tempX,y);
                            }
                        }
                    
        } else if (this.directionFacing == directionFacing.DOWN)
            {
                tempY = y + 1;
                
                    if( tempY < 0 || tempY > heightOfMap){
                      throw new IllegalMoveException(
                             String.format("I'm sorry you cant move that direction, try turning. Current location is %s, max height for map is %s ", this.currentLocation, heightOfMap));
                    } else{
                        if(map.getObjectAtLocation(new Point (x,tempY) ) == object.OBSTACLE){
                            throw new IllegalMoveException(
                                         String.format("Ouch that hurt, seems like you ran me into a %s, try turning please.", map.getObjectAtLocation(new Point(x, tempY))));
                        } else if (this.carryingPod == true && map.getObjectAtLocation(new Point (x,tempY) ) == object.POD){
                            throw new IllegalMoveException(
                                    String.format("Thats too heavy, can only carry one POD at a time, try turning or dropping your load first. (T/F) Kiva has POD: %s", carryingPod));
                        } else{
                                this.currentLocation = new Point (x,tempY);
                            }
                        }
                        
            } else if (this.directionFacing == directionFacing.RIGHT)
                {
                    tempX = x + 1;
                    
                        if( tempX < 0 || tempX > widthOfMap){
                          throw new IllegalMoveException(
                                    String.format("I'm sorry you cant move that direction, try turning. Current location is %s, max width for map is %s ", this.currentLocation, widthOfMap));
                        } else{
                            if(map.getObjectAtLocation(new Point (tempX,y) ) == object.OBSTACLE){
                                throw new IllegalMoveException(
                                             String.format("Ouch that hurt, seems like you ran me into a %s, try turning please.", map.getObjectAtLocation(new Point(tempX, y))));
                            } else if (this.carryingPod == true && map.getObjectAtLocation(new Point (tempX,y) ) == object.POD){
                                throw new IllegalMoveException(
                                        String.format("Thats too heavy, can only carry one POD at a time, try turning or dropping your load first. (T/F) Kiva has POD: %s", carryingPod));
                            } else{
                                this.currentLocation = new Point (tempX,y);
                                }
                            }
                        
                } else {
                        System.out.println("WHERE AM I, WHO ARE YOU AND WHO IS I");
                       }
}

private void turnLeft(){
    if (this.directionFacing == directionFacing.UP)
    {
        this.directionFacing = directionFacing.LEFT;
    } else if (this.directionFacing == directionFacing.LEFT)
        {
            this.directionFacing = directionFacing.DOWN;
        } else if (this.directionFacing == directionFacing.DOWN)
            {
                this.directionFacing = directionFacing.RIGHT;
            } else if (this.directionFacing == directionFacing.RIGHT)
                {
                    this.directionFacing = directionFacing.UP;
                } else {
                        System.out.println("WHERE AM I, WHO ARE YOU AND WHO IS I");
                       }
}

private void turnRight(){
    if (this.directionFacing == directionFacing.UP)
    {
        this.directionFacing = directionFacing.RIGHT;
    } else if (this.directionFacing == directionFacing.LEFT)
        {
            this.directionFacing = directionFacing.UP;
        } else if (this.directionFacing == directionFacing.DOWN)
            {
                this.directionFacing = directionFacing.LEFT;
            } else if (this.directionFacing == directionFacing.RIGHT)
                {
                    this.directionFacing = directionFacing.DOWN;
                } else {
                        System.out.println("WHERE AM I, WHO ARE YOU AND WHO IS I");
                       }
}

private void takePod()
{
    if(this.carryingPod == false && map.getObjectAtLocation(currentLocation) != object.POD)
    {
    throw new NoPodException( 
    String.format("your kiva might need some repair... its trying to grab a POD that isn't there. (T/F) Kiva has POD: %s, current location is: %s, object at this location is: %s ", 
                                                    carryingPod, currentLocation, map.getObjectAtLocation(currentLocation))); 
}
this.carryingPod = true;
}

private void dropPod()
{
        if(this.carryingPod == true && map.getObjectAtLocation(currentLocation) != object.DROP_ZONE){
        throw new IllegalDropZoneException( String.format("Sorry no public dumping allowed, this ain't California. The current location is %s and is not a %s", currentLocation, object.DROP_ZONE));
        } else if(this.carryingPod == false && map.getObjectAtLocation(currentLocation) == object.DROP_ZONE){
            throw new NoPodException( String.format("Come back here when you got the goods... no POD no WAD. (T/F) Kiva has POD: %s", carryingPod));
        } else{
        this.successfullyDropped = true;
        this.carryingPod = false;
    }
}

public boolean isCarryingPod()
{
    return carryingPod;
}

public boolean isSuccessfullyDropped()
{
    return successfullyDropped;
}
}
