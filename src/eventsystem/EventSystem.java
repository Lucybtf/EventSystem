package eventsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucía Batista Flores
 */
public class EventSystem {

    private String eventType;
    private String deviceName;
    private long time_start;
    private long time_end;

    public String getEventType() {
        return eventType;
    }

    public String getDeviceName() {
        return deviceName;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public long getTime_start() {
        return time_start;
    }

    public long getTime_end() {
        return time_end;
    }

    public void setTime_start(long time_start) {
        this.time_start = time_start;
    }

    public void setTime_end(long time_end) {
        this.time_end = time_end;
    }

    @Override
    public String toString() {
        return "EventSystem{" + "eventType=" + eventType + ", deviceName=" + deviceName + ", time_start=" + time_start + ", time_end=" + time_end + '}';
    }
   
    
    
    
      /**
     * EventOn: Turn On the device.
     * @param type
     * @param device
     * @return 
     */
    public String EventOn(String type, String device, List<EventSystem> l){
       
        for(int i = 0 ; i < l.size();i++){
            EventSystem e=l.get(i);
            if(e.getDeviceName().equals(device) && e.getEventType().equals(type) && e.time_start!= 0){
                   time_start=System.currentTimeMillis()/1000;
            }
        }
           
        return "The device is ON";
    }
    
    /**
     * EventOff: Turn Off the device.
     * @param type
     * @param device
     * @return 
     */
    public String EventOff(String type, String device, List<EventSystem> l){
        //EventSystem e;
     
        return "The device is OFF";
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        List<EventSystem> l=new ArrayList<EventSystem> ();
        EventSystem e = new EventSystem();
        
        System.out.println("Menu:\n 1. Inserte un evento.\n 2. Inicie o apage un evento.\n Pulse cualquier otra número para salir.\n ");
        int choice;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        if(br.readLine().matches("[a-zA-z]")){
            System.out.print("Introduzca un número, por favor");
        }
        else{
            System.out.println("Entramos en el bucle");
            choice = Integer.parseInt(br.readLine());
        
            while(choice==1 || choice==2){

                if(choice==1){
                     System.out.print("Introduzca tipo de evento:\n"); 
                     String input1 = br.readLine();
                     e.setEventType(input1);

                     System.out.print("Introduzca el dispositivo:\n");
                     String input2 = br.readLine();
                     e.setDeviceName(input2);

                     System.out.print(e.EventOn(input1, input2, l));
                     l.add(e);
                     System.out.print(l.toString()+"\n"); 
                     
                    /*System.out.println("Menu:\n 1. Inserte un evento.\n 2. Inicie o apage un evento.\n Pulse cualquier otra número para salir.\n ");
                    
                    BufferedReader br2= new BufferedReader(new InputStreamReader(System.in));
                    if(br2.readLine().matches("[a-zA-z]")){
                        System.out.print("Introduzca un número, por favor");
                    }
                    else{
                        System.out.println("Entramos en el bucle");
                        choice = Integer.parseInt(br2.readLine());
                    }*/
                }
                if(choice==2){
                     System.out.print("Introduzca tipo de evento:\n"); 
                     String input1 = br.readLine();
                     e.setEventType(input1);

                     System.out.print("Introduzca el dispositivo:\n");
                     String input2 = br.readLine();
                     e.setDeviceName(input2);

                     System.out.print(e.EventOn(input1, input2, l));
                     l.add(e);
                     System.out.print(l.toString()+"\n"); 
                     
                   /* System.out.println("Menu:\n 1. Inserte un evento.\n 2. Inicie o apage un evento.\n Pulse cualquier otra número para salir.\n ");
                    
                    BufferedReader br2= new BufferedReader(new InputStreamReader(System.in));
                    if(br2.readLine().matches("[a-zA-z]")){
                        System.out.print("Introduzca un número, por favor");
                    }
                    else{
                        System.out.println("Entramos en el bucle");
                        choice = Integer.parseInt(br2.readLine());
                    } */ 

            }
        
        
        }
     
    }
    }
}
    

