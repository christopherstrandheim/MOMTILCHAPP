package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;


public class DisplayDevice {
	
	private static final int COUNT = 10;

		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		String user ="display";
		String server = Common.BROKERHOST;
		int port = Common.BROKERPORT;
				
		// create a client object and use it to
		Client client = new Client(user,server,port);
		// - connect to the broker - use "display" as the username
		client.connect();
		System.out.println("DISPLAY connected");
		// - create the temperature topic on the broker
		client.createTopic("temperature");
		// - subscribe to the topic
		client.subscribe("temperature");
		// - receive messages on the topic
		System.out.println("DISPLAY subscribed, waiting...");
		for(int i = 0; i<COUNT; i++){
			System.out.println("Waiting for msg " + i);
			Message m =client.receive();
			PublishMsg pm = (PublishMsg) m;
			System.out.println("DISPLAY: " + pm.getMessage());
		}
		// - unsubscribe from the topic
		client.unsubscribe("temperature");

		// - disconnect from the broker
		client.disconnect();
		
		System.out.println("Display stopping ... ");
		
	}
}
