package TablePerClassInheritance;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle{
	
	private int NoofDoor;

	public int getNoofDoor() {
		return NoofDoor;
	}

	public void setNoofDoor(int noofDoor) {
		NoofDoor = noofDoor;
	}
	
	

}
