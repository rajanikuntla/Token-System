package tokenSystem.service;

import java.util.Scanner;
import java.util.TimerTask;

import tokenSystem.domain.Customer;

/*
 * * Adding the arrived customers to the queue based on the priority levels
 */
public class CustomerArrived extends TimerTask {

	@Override
	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("Any customer arrived(yes/no)?");
		if(input.nextLine().toLowerCase().equals("yes")) {
			Customer customer = new Customer();
			System.out.println("Is the customer a priviliged customer(yes/no)?");
			if(input.nextLine().toLowerCase().equals("yes")) {
				customer.setPrivilegedCustomer(true);
			} else {
				customer.setPrivilegedCustomer(false);
			}
			customer.setToken(++ApplicationProperties.token);
			if(customer.getPrivilegedCustomer()) {
				ApplicationProperties.customerQueue.addFirst(customer.getToken());
			} else {
				ApplicationProperties.customerQueue.addLast(customer.getToken());
			}
			ApplicationProperties.assignTokenToCounter();
		}
	}

}
