import edu.duke.*;
import java.lang.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of KivaCommandTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KivaCommandTester {
    public void testForward()
    {
        KivaCommand command = KivaCommand.FORWARD;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    
    public void testTurnLeft()
    {
        KivaCommand command = KivaCommand.TURN_LEFT;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    
    public void testTurnRight()
    {
        KivaCommand command = KivaCommand.TURN_RIGHT;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    
    public void testTake()
    {
        KivaCommand command = KivaCommand.TAKE;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    
    public void testDrop()
    {
        KivaCommand command = KivaCommand.DROP;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    
    public void testRandom()
    {
        KivaCommand F = KivaCommand.FORWARD;
        KivaCommand L = KivaCommand.TURN_LEFT;
        KivaCommand R = KivaCommand.TURN_RIGHT;
        KivaCommand T = KivaCommand.TAKE;
        KivaCommand D = KivaCommand.DROP;
        char[] kiva = {'L', 'F', 'L', 'R', 'T', 'D', 'F','F', 'L'};
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a string of the following: F,L,R,T, or D");
        String input = keyboard.nextLine().toUpperCase();
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
}
    System.out.println("bad array print" + str);
    String result = Arrays.toString(str);
    if(result.contains("null")){
        System.out.println(result);
        throw new NullPointerException("Wrong Input");
    }else{
    System.out.println("good array print" + result);
}
    KivaCommand[] kivArr = new KivaCommand[input.length()];
    
       // System.out.println("Kiv is " + kiv);
       
    }
}


