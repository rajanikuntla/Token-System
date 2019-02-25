package tokenSystem.service;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.TimerTask;

import tokenSystem.domain.Counter;

/*
 * * Releasing the counters when the customer 
 *  completes his work(assuming that the customer completes the work within 20 seconds)
 */
public class ReleaseCounter extends TimerTask {

	@Override
	public void run() {
		Iterator<Counter> counterIterator = ApplicationProperties.counters.iterator();
			
			while(counterIterator.hasNext()) {
				Counter counter = counterIterator.next();
				LocalTime now = LocalTime.now();
				if(counter.getTime() != null && now.isAfter(counter.getTime())) { 	
					counter.setAvailable(true);
					counter.setTime(null);	
					System.out.println(ApplicationProperties.counterAssignment.get(counter.getName()) + " Token completed");
					ApplicationProperties.counterAssignment.remove(counter.getName());
					ApplicationProperties.noOfCountersAvailable++;
					ApplicationProperties.assignTokenToCounter();
				}
			}
		
			
	}

}
