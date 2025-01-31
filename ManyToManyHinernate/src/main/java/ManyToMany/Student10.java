package ManyToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student10")
public class Student10 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    // A student can take multiple courses
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name
    		)
    private Set<Course10> courses = new HashSet<>();

    public Student10() {}

    public Student10(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course10> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course10> courses) {
        this.courses = courses;
    }
}
