package tokenSystem.domain;

import java.time.LocalTime;

public class Counter {

	private String name;
	private boolean available;
	private LocalTime time;
	
	public Counter(String name) {
		super();
		this.name = name;
		this.available = true;
		this.time = null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
}
