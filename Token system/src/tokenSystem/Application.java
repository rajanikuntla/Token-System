package tokenSystem;

import java.util.Timer;
import java.util.TimerTask;

import tokenSystem.service.ApplicationProperties;
import tokenSystem.service.CustomerArrived;
import tokenSystem.service.ReleaseCounter;

public class Application {
	public static void main(String args[]) {
		
		ApplicationProperties.intializeCounters();
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
		
		TimerTask addCustomers = new CustomerArrived();
		TimerTask releaseCounters = new ReleaseCounter(); 
		
		//Scheduling a timer for every 5 seconds to check whether a customer has arrived or not
		timer1.scheduleAtFixedRate(addCustomers, 0, 5000);
		
		//Scheduling a timer for every 20 seconds assuming that the work at the counter is completed for a particular customer
		timer2.scheduleAtFixedRate(releaseCounters, 0, 20000);
	}

}
