package lib;

import java.io.*;
import java.net.*;

import logic.GameManager;
public class Provider extends SocketService{
    
	ServerSocket providerSocket;
    Socket connection = null;
    String message;
    Data data;

    public Provider(){}
    public void run()
    {
    	thread = new Thread(() -> {
	        try{

	            providerSocket = new ServerSocket(2016);
	            System.out.println("Waiting for connection");
	            connection = providerSocket.accept();
	            GameManager.setReady(true);
                System.out.println("Connection received from " + connection.getInetAddress().getHostName());
                out = new ObjectOutputStream(connection.getOutputStream());
                out.flush();
                in = new ObjectInputStream(connection.getInputStream());
                
                int countLoop = 0;

                while(true) {
                    try{
                        message = (String)in.readObject();
                        data = new Data(message);
                        dataController(data);
                        
//                         data sync
                        if(countLoop%10 == 0) {
                        	System.out.println("Data Sync");
                        	for(int i = 1; i <= ConfigurableOption.mapHeight; i++) {
                        		for(int j = 1; j <= ConfigurableOption.mapWidth; j++) {
                        			sendMap(j, i, GameManager.map.getMapAt(j, i));
                        		}
                        	}
                        	sendHero(GameManager.heroes[0].getX(), GameManager.heroes[0].getY(), 1);
                        	sendHero(GameManager.heroes[1].getX(), GameManager.heroes[1].getY(), 2);
                        }
                        
                        countLoop++;
                    }
                    catch (EOFException e) {
	                	System.err.println("player lost connection");
	                	break;
	                }
                    catch (ClassNotFoundException classNot) {
                        System.err.println("data received in unknown format");
                        break;
                    } 
                    catch (IOException e) {
    					e.printStackTrace();
    					System.err.println("exception error");
    					break;
    				} 
                }
	        }
	        catch(IOException ioException){
	            ioException.printStackTrace();
	        }
	        finally{
	            try{
	                in.close();
	                out.close();
	                providerSocket.close();
	            }
	            catch(IOException ioException){
	                ioException.printStackTrace();
	            }
	        }
    	});
    	
    	thread.start();
    }   
}