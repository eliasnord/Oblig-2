package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		
		Client sensorClient = new Client("tempSensor", Common.BROKERHOST, Common.BROKERPORT);
		sensorClient.connect();
		int i = 0;
		while (i < COUNT) {
			sensorClient.publish(Common.TEMPTOPIC, sn.read() + "");
			i++;
		}
		
		sensorClient.disconnect();


		// TODO - end

		System.out.println("Temperature device stopping ... ");

		throw new UnsupportedOperationException(TODO.method());

	}
}
