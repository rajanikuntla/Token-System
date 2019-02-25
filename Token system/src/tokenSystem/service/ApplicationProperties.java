package tokenSystem.service;

import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tokenSystem.domain.Counter;

public class ApplicationProperties {

	public static Deque<Integer> customerQueue = new ArrayDeque<Integer>();
	public static int token = 0;
	public static int noOfCountersAvailable = 3;
	public static Map<String, Integer> counterAssignment = new HashMap<String, Integer>();
	public static List<Counter> counters;
	
	/*
	 * * Initializes the counters assuming that there are 3 counters with
	 *  counter names A, B, C
	 */
	public static void intializeCounters() {
		counters = new ArrayList<Counter>();
		counters.add(new Counter("A"));
		counters.add(new Counter("B"));
		counters.add(new Counter("C"));
	}
	
	/*
	 * * Display the token number along with the allocated counter
	 */
	public static void displayAssignedCounters() {
		System.out.println("---------******----------");
		for(Map.Entry<String, Integer> assignedCounter : counterAssignment.entrySet()) {			
			System.out.println(assignedCounter.getKey() + " : " + assignedCounter.getValue());			
		}
		System.out.println("---------******----------");
	}
	
	/*
	 * * Checks for counter availability
	 * If any counter is available 
	 * then assigns the token to the counter 
	 */
	public static void assignTokenToCounter() {
		if(noOfCountersAvailable > 0 && noOfCountersAvailable <= 3 && !customerQueue.isEmpty()) {
			int tempToken = customerQueue.pop();
			Iterator<Counter> counterIterator = counters.iterator();
			while(counterIterator.hasNext()) {
				Counter temp = counterIterator.next();
				if(temp.getAvailable()) {
					temp.setAvailable(false);
					temp.setTime(LocalTime.now());
					counterAssignment.put(temp.getName(), tempToken);
					--noOfCountersAvailable;
					break;
				}
			}
			displayAssignedCounters();
		}
	}
	
	
	
}
