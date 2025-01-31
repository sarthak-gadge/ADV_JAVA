package SingleTableInheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("manager")
public class Manager extends Employee{

	private double intensive;

	public double getIntensive() {
		return intensive;
	}

	public void setIntensive(double intensive) {
		this.intensive = intensive;
	}

}
