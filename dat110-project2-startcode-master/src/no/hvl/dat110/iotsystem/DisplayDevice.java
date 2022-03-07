package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
				
		Client displayDevice = new Client("display", Common.BROKERHOST, Common.BROKERPORT);
		displayDevice.connect();
		displayDevice.createTopic(Common.TEMPTOPIC);
		displayDevice.subscribe(Common.TEMPTOPIC);
		int i = 0;
		while (i < COUNT) {
			System.out.println("Displaying: " + displayDevice.receive());
			i++;
		}

		displayDevice.disconnect();
		
		
		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
		throw new UnsupportedOperationException(TODO.method());
		
	}
}
