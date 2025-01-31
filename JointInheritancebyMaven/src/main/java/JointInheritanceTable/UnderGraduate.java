package JointInheritanceTable;

import javax.persistence.Entity;

@Entity
public class UnderGraduate extends Student1{
	
	private String major;

	public UnderGraduate() {
		super();
	}

	public UnderGraduate(int id, String name, String major) {
		super(id, name);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "UnderGraduate [getId()=" + getId() + ", getName()=" + getName() + ", getMajor()=" + getMajor() + "]";

	}
	
	
	

}
