package eventsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


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
    
    public long numberSeconds(long a, long b){
        return (a>b)?a-b:b-a;
    }
   
      /**
     * EventOn: Turn On the device.
     * @param type
     * @param device
     * @return 
     */
    public List<EventSystem> EventOn(String type, String device, List<EventSystem> l){
       
        EventSystem e= new EventSystem();

        for(int i = 0 ; i < l.size();i++){
            
            e=l.get(i);
          //  System.out.print(e.toString() + "\n");
          //  System.out.print("The device is ...\n");
            if(e.getDeviceName().equals(device) && e.getEventType().equals(type) && e.getTime_end()== 0 && e.getTime_start()!=0){
                         //   System.out.print("The device is ON.\n");
                            return l;
            }
            if(e.getDeviceName().equals(device) && !e.getEventType().equals(type) && e.getTime_start()!=0 && e.getTime_end()!= 0){
                           // System.out.print("The device is OFF.\n");
                            l.remove(e);
                            e.setEventType(type);
                            e.setTime_start(System.currentTimeMillis()/1000);
                            e.setTime_end(0);
                            l.add(e);
                            return l;
            }
                
        }
            
        System.out.print("Not in the list\n");
        EventSystem ev = new EventSystem();
        ev.setEventType(type);
        ev.setDeviceName(device);
        ev.setTime_start(System.currentTimeMillis()/1000);
        l.add(ev);
        return l;
  
    }
        
    
    /**
     * EventOff: Turn Off the device.
     * @param type
     * @param device
     * @return 
     */
    public List<EventSystem> EventOff(String type, String device, List<EventSystem> l){
       
        EventSystem e= new EventSystem();
        if(l.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"The device not exist");
        }
        else{
           
            for(int i = 0 ; i < l.size();i++){
                e=l.get(i);
              
                if(e.getDeviceName().equals(device) && !e.getEventType().equals(type) && e.getTime_start()!= 0){
                  
                    e.setTime_end(System.currentTimeMillis()/1000);
                    l.remove(e); //Eliminamos el evento de la lista
                    e.setEventType("OFF"); //Apagamos el evento
                    JOptionPane.showMessageDialog(null, "ALARM "+e.getEventType()+" " + e.getDeviceName()+ " "+ e.numberSeconds(e.getTime_start(),e.getTime_end())+".\n");
                    System.out.print("ALARM " + e.getDeviceName()+ "  "+numberSeconds(e.getTime_end(), e.getTime_start()));
                    l.add(e); //Lo añadimos a la lista
                    return l;
                }
                if(e.getDeviceName().equals(device) && e.getEventType().equals(type) && e.getTime_start()!= 0 && e.getTime_end()!=0){
                  
                    System.out.print("ALARM " + e.getDeviceName()+ "  "+numberSeconds(e.getTime_end(), e.getTime_start()));
                    JOptionPane.showMessageDialog(null, "ALARM "+e.getEventType()+" " + e.getDeviceName()+ " "+ e.numberSeconds(e.getTime_start(),e.getTime_end())+".\n");
                    return l;
                }
            }
            System.out.print("Not in the list\n");
            JOptionPane.showMessageDialog(null,"The device not exist");
            
        }    
        return l;
    }
    
}

    