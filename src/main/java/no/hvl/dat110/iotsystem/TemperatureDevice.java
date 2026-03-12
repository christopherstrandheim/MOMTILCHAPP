package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to
		String user ="temperatursensor";
		String server = Common.BROKERHOST;
		int port = Common.BROKERPORT;
		Client client = new Client(user,server,port);

		// - connect to the broker - user "sensor" as the user name
		client.connect();

		// - publish the temperature(s)
		for(int i =0;i<COUNT; i++){
			int t =sn.read();
			client.publish(Common.TEMPTOPIC, String.valueOf(t));
		}


		// - disconnect from the broker
		client.disconnect();
		System.out.println("Temperature device stopping ... ");



	}
}
