package eventsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public List<EventSystem> EventOn(String type, String device, List<EventSystem> l){
       
        System.out.print("EventON\n");
      //  List<EventSystem> l= new ArrayList<EventSystem>();
        EventSystem e= new EventSystem();
        if(l.isEmpty()){
                
                e.setEventType(type);
                e.setDeviceName(device);
                e.setTime_start(System.currentTimeMillis()/1000);
                l.add(e);
                System.out.print("The device is ON and the List was empty\n");
                System.out.print("Resultados en memoria:"+ l.toString()+"\n");
                return l;
        }
        else{
            for(int i = 0 ; i < l.size();i++){
            e=l.get(i);
            if(e.getDeviceName().equals(device) && e.getEventType().equals(type) && e.time_start!= 0){
                
                  System.out.print("The device is ON. No hacemos nada");
            }
            else{
                System.out.print("The device is OFF ¿Que hacemos con los apagados?");
                e.setTime_start(System.currentTimeMillis()/1000);
                l.add(e);
             //   return l;
                }
            }
           
        }  
        return l;
    }
    
    /**
     * EventOff: Turn Off the device.
     * @param type
     * @param device
     * @return 
     */
    public List<EventSystem> EventOff(String type, String device, List<EventSystem> l){
        
        System.out.print("EventOFF\n");
        EventSystem e= new EventSystem();
        if(l.isEmpty()){
                
            System.out.print("The device not exist\n");
            return l;
        }
        else{
            for(int i = 0 ; i < l.size();i++){
                e=l.get(i);
                if(e.getDeviceName().equals(device) && !e.getEventType().equals(type) && e.getTime_start()!= 0){

                    System.out.print("The device is ON\n");
                    e.setTime_end(System.currentTimeMillis()/1000);
                    l.remove(e); //Eliminamos el evento de la lista
                    System.out.print("Switch OFF device\n");
                    e.setEventType("OFF"); //Apagamos el evento
                    l.add(e); //Lo añadimos a la lista
                    return l;
                }
                else{
                    System.out.print("The device is OFF. No hacemos nada\n");
                    
                }
            }
           
        }  
        return l;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        List<EventSystem> l=new ArrayList<EventSystem> ();
        EventSystem e = new EventSystem();
        
        System.out.println("Menu:\n 1. Inserte un evento.\n 2. Inicie o apage un evento.\n Pulse cualquier otra número para salir.\n ");
        String input;
        int choice = 0;
       // InputStreamReader input = new InputStreamReader(System.in);
       
        try {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        choice = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
           System.out.println("Not a number !");
        }
        String input_typeEvent;
        System.out.print("Introduzca tipo de evento:\n");
        BufferedReader input1= new BufferedReader(new InputStreamReader(System.in));
        input_typeEvent = input1.readLine();
        
        while(input_typeEvent.equals("ON") || input_typeEvent.equals("OFF")){
              //  System.out.print("HOLA ENTRE EN EL BUCLE");
                e.setEventType(input_typeEvent);
                if(input_typeEvent.equals("ON")){
                    
                     System.out.print("EVENTO de Encendido de Dispositivo\n");
                     System.out.print("Introduzca el dispositivo:\n");
                     BufferedReader input2= new BufferedReader(new InputStreamReader(System.in));
                     
                     String dev=input2.readLine();
                     l=e.EventOn("ON", dev, l);
                     System.out.print("Resultados en memoria:"+ l.toString()+"\n"); 
                    
                }
                if(input_typeEvent.equals("OFF")){
                    
                    System.out.print("EVENTO de Apagado de Dispositivo\n");
                    System.out.print("Introduzca el dispositivo:\n");
                    BufferedReader input2= new BufferedReader(new InputStreamReader(System.in));
                    String dev=input2.readLine();
                    l=e.EventOff("OFF", dev, l); 
                    System.out.print("Resultados en memoria:"+ l.toString()+"\n"); 
                }
                
                System.out.println("\n\nMenu:\n 1. Inserte un evento.\n 2. Inicie o apage un evento.\n Pulse cualquier otra número para salir.\n\n\n ");
                try {
                    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
                    input = br.readLine();
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                       System.out.println("Not a number !");
                }
                System.out.print("Introduzca tipo de evento:\n");
                BufferedReader inputend= new BufferedReader(new InputStreamReader(System.in));
                input_typeEvent = inputend.readLine();
        }
     
    }
}

    