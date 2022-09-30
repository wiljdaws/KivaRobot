
/**
 * Write a description of KivaMotorLifetimeTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KivaMotorLifetimeTester {
String defaultLayout = ""
                         /* x 2,4,6,8,0,2 1 3 */
                         /* y 1,1,1,1,1,1             */
    /* 1  (2,0) */         + "-----\n"
    /* 2  (2,1) */         + "|K D|\n"
    /* 3  (2,2) */         + "| P |\n"
    /* 4  (2,3) */         + "|* *|\n"
    /* 5  (2,4) */         + "-----\n";
    /* 6 */               
    
FloorMap defaultMap = new FloorMap(defaultLayout);
private void MotorLife()
{
    Kiva kiva = new Kiva(defaultMap);
    System.out.println(
            String.format("The Kiva is rated for 20,000 hours, it has: %s milliseconds / %s seconds / %s minutes / %s hours  wear on it currently", 
                                            kiva.getMotorLifetime(), (kiva.getMotorLifetime()/1000), (kiva.getMotorLifetime()/60000), (kiva.getMotorLifetime()/3600000)));
}
public void testMotorLife()
{
    Kiva kiva = new Kiva(defaultMap);
    System.out.println(
            String.format("The Kiva is rated for 20,000 hours, it has: %s milliseconds / %s seconds / %s minutes / %s hours  wear on it currently", 
                                            kiva.getMotorLifetime(), (kiva.getMotorLifetime()/1000), (kiva.getMotorLifetime()/60000), (kiva.getMotorLifetime()/3600000)));
    kiva.move(KivaCommand.TURN_RIGHT);
    System.out.println(
            String.format("The Kiva is rated for 20,000 hours, it has: %s milliseconds / %s seconds / %s minutes / %s hours  wear on it currently", 
                                            kiva.getMotorLifetime(), (kiva.getMotorLifetime()/1000), (kiva.getMotorLifetime()/60000), (kiva.getMotorLifetime()/3600000)));
        
    kiva.move(KivaCommand.FORWARD);
    System.out.println(
            String.format("The Kiva is rated for 20,000 hours, it has: %s milliseconds / %s seconds / %s minutes / %s hours  wear on it currently", 
                                            kiva.getMotorLifetime(), (kiva.getMotorLifetime()/1000), (kiva.getMotorLifetime()/60000), (kiva.getMotorLifetime()/3600000)));
    kiva.move(KivaCommand.TURN_RIGHT);
    System.out.println(
            String.format("The Kiva is rated for 20,000 hours, it has: %s milliseconds / %s seconds / %s minutes / %s hours  wear on it currently", 
                                            kiva.getMotorLifetime(), (kiva.getMotorLifetime()/1000), (kiva.getMotorLifetime()/60000), (kiva.getMotorLifetime()/3600000)));
    kiva.move(KivaCommand.FORWARD);
    System.out.println(
            String.format("The Kiva is rated for 20,000 hours, it has: %s milliseconds / %s seconds / %s minutes / %s hours  wear on it currently", 
                                            kiva.getMotorLifetime(), (kiva.getMotorLifetime()/1000), (kiva.getMotorLifetime()/60000), (kiva.getMotorLifetime()/3600000)));
    kiva.move(KivaCommand.TAKE);
   System.out.println(
            String.format("The Kiva is rated for 20,000 hours, it has: %s milliseconds / %s seconds / %s minutes / %s hours  wear on it currently", 
                                            kiva.getMotorLifetime(), (kiva.getMotorLifetime()/1000), (kiva.getMotorLifetime()/60000), (kiva.getMotorLifetime()/3600000)));
}
}
