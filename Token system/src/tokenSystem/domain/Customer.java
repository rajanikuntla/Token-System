package tokenSystem.domain;

public class Customer {
	
	private boolean privilegedCustomer;
	private int token;
	
	
	public boolean getPrivilegedCustomer() {
		return privilegedCustomer;
	}
	public void setPrivilegedCustomer(boolean privilegedCustomer) {
		this.privilegedCustomer = privilegedCustomer;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	
	

}
