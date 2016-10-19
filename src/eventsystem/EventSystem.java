package eventsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Lucía Batista Flores
 */
public class EventSystem {

    private String eventType;
    private String deviceName;
    
    /**
     * EventOn: Turn On the device.
     * @param type
     * @param device
     * @return 
     */
    public String EventOn(String type, String device){
        return null;
    }
    
    /**
     * EventOff: Turn Off the device.
     * @param type
     * @param device
     * @return 
     */
    public String EventOff(String type, String device){
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduzca tipo de evento:\n"); 
        String input1 = br.readLine();
        
        System.out.print("Introduzca el dispositivo:\n");
        String input2 = br.readLine();
        
    }
    
}
