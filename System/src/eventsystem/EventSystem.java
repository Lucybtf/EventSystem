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
   // private static final Logger log = LoggerFactory.getLogger(EventSystem.class);
    
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
            System.out.print(e.toString() + "\n");
            System.out.print("The device is ...\n");
            if(e.getDeviceName().equals(device) && e.getEventType().equals(type) && e.getTime_end()== 0 && e.getTime_start()!=0){
                            System.out.print("The device is ON.\n");
                            return l;
            }
            if(e.getDeviceName().equals(device) && !e.getEventType().equals(type) && e.getTime_start()!=0 && e.getTime_end()!= 0){
                            System.out.print("The device is OFF.\n");
                            l.remove(e);
                            e.setEventType(type);
                            e.setTime_start(System.currentTimeMillis()/1000);
                            e.setTime_end(0);
                          //  inlist=true;
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
            System.out.print("The device not exist\n");
            JOptionPane.showMessageDialog(null,"The device not exist");
            //return l;
        }
        else{
            //System.out.print("\nThe device IS ON\n");
          //  boolean inlist=false;
            for(int i = 0 ; i < l.size();i++){
                e=l.get(i);
              //  System.out.print("\nThe device IS "+ e.getEventType()+" "+ type+"the device is "+e.getDeviceName()+ " "+device+"\n");
                if(e.getDeviceName().equals(device) && !e.getEventType().equals(type) && e.getTime_start()!= 0){
                    System.out.print("The device is ON\n");
                    e.setTime_end(System.currentTimeMillis()/1000);
                    l.remove(e); //Eliminamos el evento de la lista
                    e.setEventType("OFF"); //Apagamos el evento
                    JOptionPane.showMessageDialog(null, "ALARM "+e.getEventType()+" " + e.getDeviceName()+ " "+ e.numberSeconds(e.getTime_start(),e.getTime_end())+".\n");
                    System.out.print("ALARM " + e.getDeviceName()+ "  "+numberSeconds(e.getTime_end(), e.getTime_start()));
                    l.add(e); //Lo añadimos a la lista
                    return l;
                }
                if(e.getDeviceName().equals(device) && e.getEventType().equals(type) && e.getTime_start()!= 0 && e.getTime_end()!=0){
                  //  log.debug("The device is OFF.\n");
                    System.out.print("ALARM " + e.getDeviceName()+ "  "+numberSeconds(e.getTime_end(), e.getTime_start()));
                    JOptionPane.showMessageDialog(null, "ALARM "+e.getEventType()+" " + e.getDeviceName()+ " "+ e.numberSeconds(e.getTime_start(),e.getTime_end())+".\n");
                    return l;
                }
            }
            System.out.print("Not in the list\n");
            JOptionPane.showMessageDialog(null,"The device not exist");
            /*EventSystem ev = new EventSystem();
            ev.setEventType(type);
            ev.setDeviceName(device);
            ev.setTime_start(System.currentTimeMillis()/1000);
            l.add(ev);*/
       // return l;
            
        }    
        return l;
    }
    
    /**
     * @param args the command line arguments
     */
  /*  public static void main(String[] args) {
        // TODO code application logic here
        List<EventSystem> l=new ArrayList<EventSystem> ();
        EventSystem e = new EventSystem();
        
        System.out.println("Menu:\n 1.Escriba \"ON\", si desea iniciar un dispositivo.\n 2.Escriba \"OFF\", si desea iniciar un dispositivo.\n Pulse cualquier otra número para salir.\n ");
        String input_typeEvent;
        System.out.print("Introduzca tipo de evento:\n");
       
        try {
            BufferedReader input1= new BufferedReader(new InputStreamReader(System.in));
            input_typeEvent = input1.readLine();
            while(input_typeEvent.equals("ON") || input_typeEvent.equals("OFF")){
              
                e.setEventType(input_typeEvent);
                if(input_typeEvent.equals("ON")){
                    
                     System.out.print("\nEVENTO de Encendido de Dispositivo\n\n");
                     System.out.print("Introduzca el dispositivo:\n");
                     BufferedReader input2= new BufferedReader(new InputStreamReader(System.in));
                     String dev=input2.readLine();
                     l=e.EventOn("ON", dev, l);
                     System.out.print("\nResultados en memoria:"+ l.toString()+"\n");
                     
                    
                }
                if(input_typeEvent.equals("OFF")){
                    
                    System.out.print("EVENTO de Apagado de Dispositivo\n\n");
                    System.out.print("Introduzca el dispositivo:\n");
                    BufferedReader input2= new BufferedReader(new InputStreamReader(System.in));
                    String dev=input2.readLine();
                    l=e.EventOff("OFF", dev, l); 
                    System.out.print("\nResultados en memoria:"+ l.toString()+"\n");
                    
                }
               
                System.out.println("Menu:\n 1.Escriba \"ON\", si desea iniciar un dispositivo.\n 2.Escriba \"OFF\", si desea iniciar un dispositivo.\n Pulse cualquier otra tecla para salir.\n ");
                System.out.print("Introduzca tipo de evento:\n");
                BufferedReader inputend= new BufferedReader(new InputStreamReader(System.in));
                input_typeEvent = inputend.readLine();
   
            }
             
            System.out.print("End of the Program");
            System.exit(0);
            
            } catch(IOException ex) {
           System.out.println(ex.getMessage());
        }
    }*/
}

    