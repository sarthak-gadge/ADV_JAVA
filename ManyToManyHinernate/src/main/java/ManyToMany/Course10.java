package ManyToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course10")
public class Course10 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    
    @ManyToMany(mappedBy = "courses")
    private Set<Student10> students = new HashSet<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Student10> getStudents() {
		return students;
	}


	public void setStudents(Set<Student10> students) {
		this.students = students;
	}
    
    

    

  
}
