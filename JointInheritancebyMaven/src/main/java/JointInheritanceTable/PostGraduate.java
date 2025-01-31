package JointInheritanceTable;

import javax.persistence.Entity;

@Entity
public class PostGraduate extends Student1 {

	private String master;

	public PostGraduate() {
		super();
	}

	public PostGraduate(int id, String name, String master) {
		super(id, name);
		this.master = master;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "PostGraduate [getId()=" + getId() + ", getName()=" + getName() + ", getMaster()=" + getMaster() + "]";
	}
	
	
	
	

}
