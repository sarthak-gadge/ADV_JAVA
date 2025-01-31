package TablePerClassInheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  abstract class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String brand;

	public Vehicle() {
		super();
	}

	public Vehicle(long id, String brand) {
		super();
		this.id = id;
		this.brand = brand;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", brand=" + brand + "]";
	}

}
