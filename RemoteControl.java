import edu.duke.*;
import java.io.*;
import java.util.*;
import java.lang.*;
/**
 * This is the class that controls Kiva's actions. Implement the <code>run()</code>
 * method to deliver the pod and avoid the obstacles.
 *
 * This is starter code that may or may not work. You will need to update the code to
 * complete the project.
 */
public class RemoteControl {
    KeyboardResource keyboardResource;

    /**
     * Build a new RemoteControl.
     */
    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity. Prompts the user for the floor map
     * to load, displays the map, and asks the user for the commands for Kiva to execute.
     *
     * [Here's the method you'll execute from within BlueJ. It may or may not run successfully
     * as-is, but you'll definitely need to add more to complete the project.]
     */
    public void run() {
        System.out.println("Please select a map file.");
        FileResource fileResource = new FileResource();
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        System.out.println(floorMap);
        Kiva kiva = new Kiva(floorMap);
        System.out.println(
        String.format("Kiva is at %s and facing %s, pod is at %s, drop zone is at %s", floorMap.getInitialKivaLocation(), kiva.getDirectionFacing(), floorMap.getPodLocation(), floorMap.getDropZoneLocation()));

        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        System.out.println("Directions that you typed in: " + directions);
        KivaCommand[] k = convertToKivaCommands(directions);
        for( KivaCommand i: k){
           kiva.move(i);
           kiva.getCurrentLocation();
            if(k[k.length - 1] != KivaCommand.DROP){
                System.out.println("I'm sorry. The Kiva Robot did not pick up the pod then drop it off in the right place");
                break;
            } else {
                 
                if(kiva.isSuccessfullyDropped() == true && kiva.isCarryingPod() == false){
                System.out.println("Succesfully picked up the pod and dropped it off. Thank you!");
            }  
        }
    }
    }
    public KivaCommand[] convertToKivaCommands(String commands)
    {

        
        KivaCommand F = KivaCommand.FORWARD;
        KivaCommand L = KivaCommand.TURN_LEFT;
        KivaCommand R = KivaCommand.TURN_RIGHT;
        KivaCommand T = KivaCommand.TAKE;
        KivaCommand D = KivaCommand.DROP;
        
        String input = commands.toUpperCase();
        KivaCommand[] str = new KivaCommand[input.length()]; 
            for( int i = 0; i < input.length(); i++ )
            {
            char ch =  input.charAt(i);
        
             if( ch == 'F'){
                 str[i] = F;
                 //System.out.println(F);
                } 
                else if ( ch == 'L' ){
                    str[i] = L;
                    //System.out.println(L);
                }
                else if (ch == 'R' ) {
                    str[i] = R;
                    //System.out.println(R);
                }
                else if (ch == 'T' ) {
                    str[i] = T;
                //System.out.println(T);
            }
            else if (ch == 'D' ) {
                str[i] = D;
                //System.out.println(D);
            }
            else{
                throw new IllegalArgumentException(String.format("Character %c does not correspond to a command!", ch));
            }
        }

        String result = Arrays.toString(str);
            // if(result.contains("null")){
           // System.out.println(result);
            //System.out.print("Input contained alien command not equal to (F/f, L/l, R/r, T/t, D/d) @null ... please try again"); 
           // throw new NullPointerException("Wrong Input");
           // }else{
            System.out.println(result);
            // }
        KivaCommand[] kivArr = new KivaCommand[input.length()];
        return str;
    }    
}
      
    //return k;

