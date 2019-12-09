package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Teachers")
public class Teachers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int salary;

    private int age;

    @OneToMany(mappedBy = "teacher", cascade=CascadeType.ALL)
    private Set<Courses> coursesSet;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Courses> getCoursesSet() {
        return coursesSet;
    }

    public void setCoursesSet(Set<Courses> coursesSet) {
        this.coursesSet = coursesSet;
    }
}
