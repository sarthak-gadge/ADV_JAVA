package TablePerClassInheritance;

import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle{
	
	private String biketype;

	public String getBiketype() {
		return biketype;
	}

	public void setBiketype(String biketype) {
		this.biketype = biketype;
	}
	
	

}
